package org.richit.materialofficeaboutlib.Activities;


import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import org.richit.materialofficeaboutlib.Adapters.LinksRecyclerviewAdapter;
import org.richit.materialofficeaboutlib.Adapters.MembersRecyclerviewAdapter;
import org.richit.materialofficeaboutlib.Models.Member;
import org.richit.materialofficeaboutlib.Models.OfficeInfo;
import org.richit.materialofficeaboutlib.Others.OfficeAboutHelper;
import org.richit.materialofficeaboutlib.Others.OfficeAboutListener;
import org.richit.materialofficeaboutlib.Others.OfficeAboutLoader;
import org.richit.materialofficeaboutlib.R;

import java.util.ArrayList;
import java.util.Collections;

public class OfficeAboutActivity extends AppCompatActivity {
    private String TAG = this.getClass().getSimpleName();

    private RecyclerView recyclerViewMembers, recyclerViewLinks;
    private RecyclerView.Adapter membersAdapter, linksAdapter;
    private ImageView imageViewOfficeLogo;
    private SwipeRefreshLayout swipeRefreshLayout;
    private Toolbar toolbar;
    LinearLayout linearLayoutParent;
    CardView cardViewAbout, cardViewMembers;

    private String jsonUrl;
    private boolean showToolbar;
    private boolean shuffleMembers = false;
    private String name = "";
    private String designation = "";
    private boolean exact = false;

    SharedPreferences sharedPreferences;
    String SAVED_JSON = "SAVED_JSON";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.material_office_about);
        initSP(this);

        toolbar = findViewById(R.id.toolbar);
        imageViewOfficeLogo = findViewById(R.id.officeLogoImage);
        swipeRefreshLayout = findViewById(R.id.srl);
        linearLayoutParent = findViewById(R.id.dummyLl);
        cardViewAbout = findViewById(R.id.aboutCv);
        cardViewMembers = findViewById(R.id.membersCv);

        swipeRefreshLayout.setEnabled(false);

        showToolbar = getIntent().getBooleanExtra("showToolbar", false);
        jsonUrl = getIntent().getStringExtra("jsonUrl");
        shuffleMembers = getIntent().getBooleanExtra("shuffleMembers", false);
        name = getIntent().getStringExtra("name");
        designation = getIntent().getStringExtra("designation");
        exact = getIntent().getBooleanExtra("exact", false);

        if (showToolbar) {
            toolbar.setVisibility(View.VISIBLE);
            setSupportActionBar(toolbar);
            getSupportActionBar().setHomeButtonEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setDisplayShowTitleEnabled(false);
        } else {
            toolbar.setVisibility(View.GONE);
        }

        recyclerViewMembers = findViewById(R.id.membersRv);
        recyclerViewLinks = findViewById(R.id.linksRv);

        recyclerViewMembers.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewLinks.setLayoutManager(new LinearLayoutManager(this));

        String jsonStr = getString(SAVED_JSON, "");
        if (jsonStr.isEmpty()) {
            getDataFromOnline();
        } else {
            if (OfficeAboutLoader.isNetworkAvailable(this)) {
                getDataFromOnline();
            } else {
                OfficeInfo officeInfo = new Gson().fromJson(jsonStr, OfficeInfo.class);
                showCorrectData(officeInfo);
            }
        }
    }

    private void getDataFromOnline() {
        swipeRefreshLayout.setRefreshing(true);
        new OfficeAboutLoader(this, jsonUrl, new OfficeAboutListener() {

            @Override
            public void onJsonDataReceived(OfficeInfo officeInfo, String jsonFromOnline) {
                showCorrectData(officeInfo);
                if (OfficeAboutHelper.loadListener != null)
                    OfficeAboutHelper.loadListener.onLoad(linearLayoutParent);

                putSP(SAVED_JSON, jsonFromOnline);
            }

            @Override
            public void onError(String error) {
                Log.d(TAG, "onError: " + error);
                finish();

                if (OfficeAboutHelper.loadListener == null)
                    Toast.makeText(OfficeAboutActivity.this, "" + error, Toast.LENGTH_SHORT).show();
                else
                    OfficeAboutHelper.loadListener.onError(error);

            }
        }).execute();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    private void checkConditions(ArrayList<Member> memberArrayList) {
        if (shuffleMembers) {
            Collections.shuffle(memberArrayList);
            for (int i = 0; i < memberArrayList.size(); i++) {
                Member memberTop = null;
                if (exact) {
                    if (!name.isEmpty() && memberArrayList.get(i).getName().equals(name)) {
                        memberTop = memberArrayList.get(i);
                    } else if (!designation.isEmpty() && memberArrayList.get(i).getDesignation().toLowerCase().equals(designation.toLowerCase())) {
                        memberTop = memberArrayList.get(i);
                    }
                } else {
                    if (!name.isEmpty() && memberArrayList.get(i).getName().contains(name)) {
                        memberTop = memberArrayList.get(i);
                    } else if (!designation.isEmpty() && memberArrayList.get(i).getDesignation().toLowerCase().contains(designation.toLowerCase())) {
                        memberTop = memberArrayList.get(i);
                    }
                }

                if (memberTop != null) {
                    memberArrayList.remove(i);
                    memberArrayList.add(0, memberTop);
                    break;
                }
            }
        }
    }

    private void initSP(Context context) {
        if (sharedPreferences == null) {
            sharedPreferences = context.getSharedPreferences("OfficeAbout", Context.MODE_PRIVATE);
        }
    }

    private void putSP(String title, String value) {
        sharedPreferences.edit().putString(title, value).apply();
    }

    private String getString(String title, String defaultValue) {
        return sharedPreferences.getString(title, defaultValue);
    }

    private void showCorrectData(OfficeInfo officeInfo) {
        Log.d(TAG, "onJsonDataReceived: ");

        Picasso.get().load(officeInfo.getOfficeLogoUrl()).into(imageViewOfficeLogo);

        if (officeInfo.getLinks().size() == 0) {
            cardViewAbout.setVisibility(View.GONE);
        } else {
            linksAdapter = new LinksRecyclerviewAdapter(OfficeAboutActivity.this, officeInfo.getLinks());
            recyclerViewLinks.setAdapter(linksAdapter);
        }

        if (officeInfo.getMembers().size() == 0) {
            cardViewMembers.setVisibility(View.GONE);
        } else {
            checkConditions(officeInfo.getMembers());
            membersAdapter = new MembersRecyclerviewAdapter(OfficeAboutActivity.this, officeInfo.getMembers());
            recyclerViewMembers.setAdapter(membersAdapter);
        }

        swipeRefreshLayout.setRefreshing(false);
    }
}
