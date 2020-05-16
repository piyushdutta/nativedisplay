package com.pushnotification.nativedisplay;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import androidx.annotation.Nullable;

import com.clevertap.android.sdk.CleverTapAPI;
import com.clevertap.android.sdk.displayunits.model.CleverTapDisplayUnit;


import java.lang.ref.WeakReference;
import java.util.ArrayList;

import static com.pushnotification.nativedisplay.DisplayLauncherActivity.callInputIntent;
import static com.pushnotification.nativedisplay.DisplayLauncherActivity.callIntent;


public class nativedisplay{

    public static boolean isnativepayload(ArrayList<CleverTapDisplayUnit> units, Context context)
    {
        boolean template = false;
        String unitid = units.get(0).getUnitID();
        CleverTapAPI.getDefaultInstance(context).pushDisplayUnitViewedEventForID(unitid);

        try {
            Log.d("units_custome", units.get(0).getCustomExtras().get("template"));
            String template_1 = units.get(0).getCustomExtras().get("template");
            Log.d("units_custome", units.get(0).getCustomExtras().toString());
            if(template_1.equalsIgnoreCase("true"))
            {
                template =true;

                String custom = units.get(0).getCustomExtras().get("custom ");
                if(custom.equalsIgnoreCase("rating"))
                {
                    String title, message;
                    title = units.get(0).getCustomExtras().get("title");
                    message = units.get(0).getCustomExtras().get("message");
                    Activity currentActivity = getCurrentActivity();
                    callIntent(context, unitid,title,message,currentActivity);

                }
                else if(custom.equalsIgnoreCase("input"))
                {
                    String title, message, inputtitle1, inputtitle2, pushvalue;
                    title = units.get(0).getCustomExtras().get("title");
                    message = units.get(0).getCustomExtras().get("message");
                    inputtitle1 = units.get(0).getCustomExtras().get("inputtitle1");
                    inputtitle2 = units.get(0).getCustomExtras().get("inputtitle2");
                    pushvalue = units.get(0).getCustomExtras().get("inputtitle2");

                    Activity currentActivity = getCurrentActivity();
                    callInputIntent(context, unitid,title,message,inputtitle1, inputtitle2, pushvalue, currentActivity);
                }
                else
                {
                    return template;
                }

            }

        }catch (Exception e)
        {
            Log.d("what is this", e.toString());
        }

        return template;

    }

    public static void setCurrentActivity(@Nullable Activity activity) {
        if (activity == null) {
            currentActivity = null;
            return;
        }
        if (!activity.getLocalClassName().contains("InAppNotificationActivity")) {
            currentActivity = new WeakReference<>(activity);
        }
    }

    private static Activity getCurrentActivity() {
        return (currentActivity == null) ? null : currentActivity.get();
    }

    private static WeakReference<Activity> currentActivity;
}