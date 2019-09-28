package org.richit.materialofficeaboutlib.Activities;


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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.squareup.picasso.Picasso;

import org.richit.materialofficeaboutlib.Adapters.LinksRecyclerviewAdapter;
import org.richit.materialofficeaboutlib.Adapters.MembersRecyclerviewAdapter;
import org.richit.materialofficeaboutlib.Models.OfficeInfo;
import org.richit.materialofficeaboutlib.Others.OfficeAboutHelper;
import org.richit.materialofficeaboutlib.Others.OfficeAboutListener;
import org.richit.materialofficeaboutlib.Others.OfficeAboutLoader;
import org.richit.materialofficeaboutlib.R;

public class OfficeAboutActivity extends AppCompatActivity {
    private String TAG = this.getClass().getSimpleName();

    private RecyclerView recyclerViewMembers, recyclerViewLinks;
    private RecyclerView.Adapter membersAdapter, linksAdapter;
    private ImageView imageViewOfficeLogo;
    private SwipeRefreshLayout swipeRefreshLayout;
    private Toolbar toolbar;
    private boolean showToolbar;
    LinearLayout linearLayoutParent;
    private String jsonUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.material_office_about);

        toolbar = findViewById(R.id.toolbar);
        imageViewOfficeLogo = findViewById(R.id.officeLogoImage);
        swipeRefreshLayout = findViewById(R.id.srl);
        linearLayoutParent = findViewById(R.id.dummyLl);

        swipeRefreshLayout.setEnabled(false);

        showToolbar = getIntent().getBooleanExtra("showToolbar", false);
        jsonUrl = getIntent().getStringExtra("jsonUrl");

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

        recyclerViewMembers.setAdapter(membersAdapter);
        recyclerViewLinks.setAdapter(linksAdapter);

        swipeRefreshLayout.setRefreshing(true);
        new OfficeAboutLoader(this, jsonUrl, new OfficeAboutListener() {
            @Override
            public void onJsonDataReceived(OfficeInfo officeInfo) {
                Log.d(TAG, "onJsonDataReceived: ");

                Picasso.get().load(officeInfo.getOfficeLogoUrl()).into(imageViewOfficeLogo);
                membersAdapter = new MembersRecyclerviewAdapter(OfficeAboutActivity.this, officeInfo.getMembers());
                linksAdapter = new LinksRecyclerviewAdapter(OfficeAboutActivity.this, officeInfo.getLinks());

                recyclerViewMembers.setAdapter(membersAdapter);
                recyclerViewLinks.setAdapter(linksAdapter);

                swipeRefreshLayout.setRefreshing(false);

                if (OfficeAboutHelper.loadListener != null)
                    OfficeAboutHelper.loadListener.onLoad(linearLayoutParent);
            }

            @Override
            public void onError(String error) {
                Log.d(TAG, "onError: " + error);
                finish();


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
}
