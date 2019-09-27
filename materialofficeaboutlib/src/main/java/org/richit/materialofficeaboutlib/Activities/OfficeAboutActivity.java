package org.richit.materialofficeaboutlib.Activities;


import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.richit.materialofficeaboutlib.Adapters.MembersRecyclerviewAdapter;
import org.richit.materialofficeaboutlib.Models.Link;
import org.richit.materialofficeaboutlib.Models.Member;
import org.richit.materialofficeaboutlib.Models.OfficeInfo;
import org.richit.materialofficeaboutlib.Others.MembersListener;
import org.richit.materialofficeaboutlib.Others.OfficeAboutLoader;
import org.richit.materialofficeaboutlib.R;

import java.util.ArrayList;

public class OfficeAboutActivity extends AppCompatActivity {

    public static String jsonUrl;

    RecyclerView recyclerViewMembers;
    RecyclerView.Adapter membersAdapter;
    LinearLayoutManager manager;
    ImageView imageViewOfficeLogo;
    NestedScrollView nestedScrollViewParent;

    ArrayList<Member> members = new ArrayList<>();
    ArrayList<Link> links = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.material_office_about);

        nestedScrollViewParent = findViewById(R.id.parentNsv);
        imageViewOfficeLogo = findViewById(R.id.officeLogoImage);

        recyclerViewMembers = findViewById(R.id.officeAboutRecyclerView);
        manager = new LinearLayoutManager(this);
        recyclerViewMembers.setLayoutManager(manager);
        membersAdapter = new MembersRecyclerviewAdapter(OfficeAboutActivity.this, members);
        recyclerViewMembers.setAdapter(membersAdapter);

        new OfficeAboutLoader(this, "", new MembersListener() {
            @Override
            public void onJsonDataReceived(OfficeInfo officeInfo) {

            }

            @Override
            public void onError(String error) {

            }
        }).execute();
    }
}
