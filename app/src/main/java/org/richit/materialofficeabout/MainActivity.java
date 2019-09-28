package org.richit.materialofficeabout;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import org.richit.materialofficeaboutlib.Others.LoadListener;
import org.richit.materialofficeaboutlib.Others.OfficeAboutHelper;

public class MainActivity extends AppCompatActivity {

    OfficeAboutHelper officeAboutHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        officeAboutHelper = new OfficeAboutHelper(this, "https://raw.githubusercontent.com/p32929/SomeHowTosAndTexts/master/Office/OfficeInfoMaterial.json");
    }

    public void showAboutActivityNormally(View view) {
        officeAboutHelper.showAboutActivity();
    }

    public void showAboutActivityWithDummyLayout(View view) {
        officeAboutHelper.showAboutActivity(true, new LoadListener() {
            @Override
            public void onLoad(LinearLayout linearLayoutDummy) {
                // You might wanna add some more views below the activity layout
                linearLayoutDummy.addView(LayoutInflater.from(MainActivity.this).inflate(R.layout.just_a_dummy_layout, null));
            }

            @Override
            public void onError(String error) {
                // You might wanna show a toast here with the error string
            }
        });
    }
}
