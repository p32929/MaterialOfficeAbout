package org.richit.materialofficeabout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import org.richit.materialofficeaboutlib.Others.OfficeAboutHelper;

public class MainActivity extends AppCompatActivity {

    OfficeAboutHelper officeAboutHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        officeAboutHelper = new OfficeAboutHelper(this, "https://raw.githubusercontent.com/p32929/SomeHowTosAndTexts/master/Office/OfficeInfo.json");
        officeAboutHelper.showAboutActivity();
    }

    public void showAboutActivity(View view) {
        officeAboutHelper.showAboutActivity();
    }
}
