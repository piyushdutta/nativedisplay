package com.pushnotification.nativedisplay;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;


public class DisplayLauncherActivity extends AppCompatActivity {


    public static void callIntent(Context context, String unitId1, String title1, String message1,Activity currentActivity )
    {
        Intent intent = new Intent(android.content.Intent.ACTION_VIEW);
        intent.putExtra("unitId",unitId1);
        intent.putExtra("title",title1);
        intent.putExtra("message",message1);

        intent.setComponent(new ComponentName(context,
                "com.pushnotification.nativedisplay.RatingActivity"));

        currentActivity.startActivity(intent);
    }

    public static void callInputIntent(Context context, String unitId1, String title1, String message1,String inputtitle1, String inputtitle2,String pushvalue, Activity currentActivity )
    {
        Intent intent = new Intent(android.content.Intent.ACTION_VIEW);
        intent.putExtra("unitId",unitId1);
        intent.putExtra("title",title1);
        intent.putExtra("message",message1);
        intent.putExtra("inputtitle1",inputtitle1);
        intent.putExtra("inputtitle2",inputtitle2);
        intent.putExtra("passvalue",pushvalue);

        intent.setComponent(new ComponentName(context,
                "com.pushnotification.nativedisplay.InputActivity"));

        currentActivity.startActivity(intent);
    }



}
