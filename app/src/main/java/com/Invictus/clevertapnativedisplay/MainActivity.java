package com.Invictus.clevertapnativedisplay;

import androidx.appcompat.app.AppCompatActivity;
import android.app.NotificationManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.clevertap.android.sdk.CleverTapAPI;



public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final CleverTapAPI cleverTapAPI = CleverTapAPI.getDefaultInstance(getApplicationContext());

        cleverTapAPI.setDebugLevel(CleverTapAPI.LogLevel.DEBUG);

    }

}
