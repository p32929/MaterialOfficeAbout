package org.richit.materialofficeaboutlib.Others;

import android.content.Context;
import android.content.Intent;

import org.richit.materialofficeaboutlib.Activities.OfficeAboutActivity;

public class OfficeAboutHelper {
    private Context context;
    private String jsonUrl;
    public static LoadListener loadListener;
    private boolean shuffleMembers = false;
    private String name = "";
    private String designation = "";
    private boolean exact = false;

    public OfficeAboutHelper(Context context, String jsonUrl) {
        this.context = context;
        this.jsonUrl = jsonUrl;
    }

    public void shuffleMembers() {
        shuffleMembers = true;
    }

    public void shuffleMembersByName(String name, boolean exact) {
        shuffleMembers = true;
        this.name = name;
        this.exact = exact;
    }

    public void shuffleMembersByDesignation(String designation, boolean exact) {
        shuffleMembers = true;
        this.designation = designation;
        this.exact = exact;
    }

    public void showAboutActivity(boolean showToolbar) {
        Intent intent = new Intent(context, OfficeAboutActivity.class);
        intent.putExtra("jsonUrl", jsonUrl);
        intent.putExtra("showToolbar", showToolbar);
        intent.putExtra("shuffleMembers", shuffleMembers);
        intent.putExtra("name", name);
        intent.putExtra("designation", designation);
        intent.putExtra("exact", exact);
        context.startActivity(intent);
    }

    public void showAboutActivity(boolean showToolbar, LoadListener listener) {
        loadListener = listener;
        Intent intent = new Intent(context, OfficeAboutActivity.class);
        intent.putExtra("jsonUrl", jsonUrl);
        intent.putExtra("showToolbar", showToolbar);
        intent.putExtra("shuffleMembers", shuffleMembers);
        intent.putExtra("name", name);
        intent.putExtra("designation", designation);
        intent.putExtra("exact", exact);
        context.startActivity(intent);
    }

    public void showAboutActivity(LoadListener listener) {
        loadListener = listener;
        Intent intent = new Intent(context, OfficeAboutActivity.class);
        intent.putExtra("jsonUrl", jsonUrl);
        intent.putExtra("showToolbar", true);
        intent.putExtra("shuffleMembers", shuffleMembers);
        intent.putExtra("name", name);
        intent.putExtra("designation", designation);
        intent.putExtra("exact", exact);
        context.startActivity(intent);
    }

    public void showAboutActivity() {
        Intent intent = new Intent(context, OfficeAboutActivity.class);
        intent.putExtra("jsonUrl", jsonUrl);
        intent.putExtra("showToolbar", true);
        intent.putExtra("shuffleMembers", shuffleMembers);
        intent.putExtra("name", name);
        intent.putExtra("designation", designation);
        intent.putExtra("exact", exact);
        context.startActivity(intent);
    }
}
