package org.richit.materialofficeaboutlib.Activities;


import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import org.richit.materialofficeaboutlib.Adapters.LinksRecyclerviewAdapter;
import org.richit.materialofficeaboutlib.Adapters.MembersRecyclerviewAdapter;
import org.richit.materialofficeaboutlib.Models.Link;
import org.richit.materialofficeaboutlib.Models.Member;
import org.richit.materialofficeaboutlib.Models.OfficeInfo;
import org.richit.materialofficeaboutlib.Others.MembersListener;
import org.richit.materialofficeaboutlib.Others.OfficeAboutLoader;
import org.richit.materialofficeaboutlib.R;

import java.util.ArrayList;

public class OfficeAboutActivity extends AppCompatActivity {
    private String TAG = this.getClass().getSimpleName();
    public static String jsonUrl;

    private RecyclerView recyclerViewMembers, recyclerViewLinks;
    private RecyclerView.Adapter membersAdapter, linksAdapter;
    private ImageView imageViewOfficeLogo;
    private NestedScrollView nestedScrollViewParent;

    private ArrayList<Member> members = new ArrayList<>();
    private ArrayList<Link> links = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.material_office_about);

        imageViewOfficeLogo = findViewById(R.id.officeLogoImage);

        nestedScrollViewParent = findViewById(R.id.parentNsv);
        imageViewOfficeLogo = findViewById(R.id.officeLogoImage);

        recyclerViewMembers = findViewById(R.id.membersRv);
        recyclerViewLinks = findViewById(R.id.linksRv);

        recyclerViewMembers.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewLinks.setLayoutManager(new LinearLayoutManager(this));

        recyclerViewMembers.setAdapter(membersAdapter);
        recyclerViewLinks.setAdapter(linksAdapter);

        new OfficeAboutLoader(this, "https://raw.githubusercontent.com/p32929/SomeHowTosAndTexts/master/Office/OfficeInfoMaterial.json", new MembersListener() {
            @Override
            public void onJsonDataReceived(OfficeInfo officeInfo) {
                Log.d(TAG, "onJsonDataReceived: ");

                Picasso.get().load(officeInfo.getOfficeLogoUrl()).into(imageViewOfficeLogo);
                membersAdapter = new MembersRecyclerviewAdapter(OfficeAboutActivity.this, officeInfo.getMembers());
                linksAdapter = new LinksRecyclerviewAdapter(OfficeAboutActivity.this, officeInfo.getLinks());

                recyclerViewMembers.setAdapter(membersAdapter);
                recyclerViewLinks.setAdapter(linksAdapter);
            }

            @Override
            public void onError(String error) {
                Log.d(TAG, "onError: ");
            }
        }).execute();
    }
}
