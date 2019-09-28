package org.richit.materialofficeaboutlib.Others;

import android.content.Context;
import android.content.Intent;
import android.widget.LinearLayout;

import org.richit.materialofficeaboutlib.Activities.OfficeAboutActivity;

public class OfficeAboutHelper {
    private Context context;
    private String jsonUrl;
    public static ShowListener listener;

    public interface ShowListener {
        void onShow(LinearLayout linearLayoutParent);
    }

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

    public void showAboutActivity(boolean showToolbar, ShowListener showListener) {
        listener = showListener;
        Intent intent = new Intent(context, OfficeAboutActivity.class);
        intent.putExtra("jsonUrl", jsonUrl);
        intent.putExtra("showToolbar", showToolbar);
        context.startActivity(intent);
    }

    public void showAboutActivity() {
        Intent intent = new Intent(context, OfficeAboutActivity.class);
        intent.putExtra("jsonUrl", jsonUrl);
        intent.putExtra("showToolbar", true);
        context.startActivity(intent);
    }
}
