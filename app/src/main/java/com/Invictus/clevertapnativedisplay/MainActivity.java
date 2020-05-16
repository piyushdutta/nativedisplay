package com.Invictus.clevertapnativedisplay;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.NotificationManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import com.clevertap.android.sdk.CleverTapAPI;
import com.clevertap.android.sdk.displayunits.DisplayUnitListener;
import com.clevertap.android.sdk.displayunits.model.CleverTapDisplayUnit;
import com.pushnotification.nativedisplay.nativedisplay;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity implements DisplayUnitListener{



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final CleverTapAPI cleverTapAPI = CleverTapAPI.getDefaultInstance(getApplicationContext());

        cleverTapAPI.setDebugLevel(CleverTapAPI.LogLevel.DEBUG);
        CleverTapAPI.getDefaultInstance(this).setDisplayUnitListener(this);


    }


    @Override
    public void onDisplayUnitsLoaded(ArrayList<CleverTapDisplayUnit> units) {
        // you will get display units here
        for (int i = 0; i <units.size() ; i++) {
            CleverTapDisplayUnit unit = units.get(i);
            nativedisplay.setCurrentActivity(MainActivity.this);
            Log.d("units",units.get(0).toString() );
            if(!nativedisplay.isnativepayload(units,getApplicationContext()))
            {

            }
           // routeto(units);
        }
    }

}
