package com.pushnotification.nativedisplay;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class DisplayLauncherActivity extends AppCompatActivity {

    public static void callIntent(Context context, String unitId1, String title1, String message1)
    {
        Intent intent = new Intent(context,com.pushnotification.nativedisplay.RatingActivity.class);
        intent.putExtra("unitId",unitId1);
        intent.putExtra("title",title1);
        intent.putExtra("message",message1);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        context.startActivity(intent);
    }

}
