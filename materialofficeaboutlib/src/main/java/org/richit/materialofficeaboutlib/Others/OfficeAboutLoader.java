package org.richit.materialofficeaboutlib.Others;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.Gson;

import org.richit.materialofficeaboutlib.Models.OfficeInfo;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.Charset;

public class OfficeAboutLoader extends AsyncTask<Void, Void, String> {

    String TAG = getClass().getSimpleName();

    Context context;
    String jsonUrl;
    OfficeAboutListener listener;

    public OfficeAboutLoader(Context context, String jsonUrl, OfficeAboutListener listener) {
        this.context = context;
        this.jsonUrl = jsonUrl;
        this.listener = listener;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();

        if (context == null || listener == null || jsonUrl == null) {
            Log.d(TAG, "onPreExecute: context == null || listener == null || jsonUrl == null");
            cancel(true);
        } else if (!isNetworkAvailable(context)) {
            listener.onError("Please check your network connection");
            cancel(true);
        } else if (jsonUrl.isEmpty()) {
            listener.onError("Please provide a valid JSON URL");
            cancel(true);
        }
    }

    @Override
    protected String doInBackground(Void... voids) {
        try {
            URL url = new URL(jsonUrl);
            InputStream is = url.openStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));

            StringBuilder sb = new StringBuilder();
            int cp;
            while ((cp = bufferedReader.read()) != -1) {
                sb.append((char) cp);
            }
            return sb.toString();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onPostExecute(String jsonString) {
        super.onPostExecute(jsonString);
        OfficeInfo officeInfo = new Gson().fromJson(jsonString, OfficeInfo.class);
        if (officeInfo == null) {
            listener.onError("NULL OfficeInfo Object");
        } else {
            listener.onJsonDataReceived(officeInfo, jsonString);
        }
    }

    public static boolean isNetworkAvailable(Context ctx) {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) ctx.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }
}
