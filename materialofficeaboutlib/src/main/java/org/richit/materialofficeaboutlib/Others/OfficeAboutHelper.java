package org.richit.materialofficeaboutlib.Others;

import android.content.Context;
import android.content.Intent;

import org.richit.materialofficeaboutlib.Activities.OfficeAboutActivity;

public class OfficeAboutHelper {
    private Context context;
    private String jsonUrl;
    public static LoadListener loadListener;

    public OfficeAboutHelper(Context context, String jsonUrl) {
        this.context = context;
        this.jsonUrl = jsonUrl;
    }

    public void showAboutActivity(boolean showToolbar) {
        Intent intent = new Intent(context, OfficeAboutActivity.class);
        intent.putExtra("jsonUrl", jsonUrl);
        intent.putExtra("showToolbar", showToolbar);
        context.startActivity(intent);
    }

    public void showAboutActivity(boolean showToolbar, LoadListener listener) {
        loadListener = listener;
        Intent intent = new Intent(context, OfficeAboutActivity.class);
        intent.putExtra("jsonUrl", jsonUrl);
        intent.putExtra("showToolbar", showToolbar);
        context.startActivity(intent);
    }

    public void showAboutActivity(LoadListener listener) {
        loadListener = listener;
        Intent intent = new Intent(context, OfficeAboutActivity.class);
        intent.putExtra("jsonUrl", jsonUrl);
        intent.putExtra("showToolbar", true);
        context.startActivity(intent);
    }

    public void showAboutActivity() {
        Intent intent = new Intent(context, OfficeAboutActivity.class);
        intent.putExtra("jsonUrl", jsonUrl);
        intent.putExtra("showToolbar", true);
        context.startActivity(intent);
    }
}
