package org.richit.materialofficeaboutlib.Others;

import android.content.Context;
import android.content.Intent;

import org.richit.materialofficeaboutlib.Activities.OfficeAboutActivity;

public class OfficeAboutHelper {
    Context context;
    String jsonUrl;

    public OfficeAboutHelper(Context context, String jsonUrl) {
        this.context = context;
        this.jsonUrl = jsonUrl;

        OfficeAboutActivity.jsonUrl = jsonUrl;
    }

    public void showAboutActivity() {
        context.startActivity(new Intent(context, OfficeAboutActivity.class));
    }
}
