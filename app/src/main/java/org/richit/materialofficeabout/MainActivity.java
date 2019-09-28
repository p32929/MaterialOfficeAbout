package org.richit.materialofficeabout;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import org.richit.materialofficeaboutlib.Others.OfficeAboutHelper;

public class MainActivity extends AppCompatActivity {

    OfficeAboutHelper officeAboutHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        officeAboutHelper = new OfficeAboutHelper(this, "https://raw.githubusercontent.com/p32929/SomeHowTosAndTexts/master/Office/OfficeInfoMaterial.json");
        officeAboutHelper.showAboutActivity(true);
    }

    public void showAboutActivity(View view) {
        officeAboutHelper.showAboutActivity(false, new OfficeAboutHelper.ShowListener() {
            @Override
            public void onShow(LinearLayout linearLayoutParent) {
                linearLayoutParent.addView(LayoutInflater.from(MainActivity.this).inflate(R.layout.just_a_dummy_layout, null));
            }
        });
    }
}
