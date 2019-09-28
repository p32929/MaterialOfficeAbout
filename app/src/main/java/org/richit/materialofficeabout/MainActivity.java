package org.richit.materialofficeabout;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import org.richit.materialofficeaboutlib.Others.OfficeAboutHelper;

public class MainActivity extends AppCompatActivity {

    OfficeAboutHelper officeAboutHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        officeAboutHelper = new OfficeAboutHelper(this, "https://raw.githubusercontent.com/p32929/SomeHowTosAndTexts/master/Office/OfficeInfo.json");
        officeAboutHelper.showAboutActivity(true);
    }

    public void showAboutActivity(View view) {
        officeAboutHelper.showAboutActivity(false);
    }
}
