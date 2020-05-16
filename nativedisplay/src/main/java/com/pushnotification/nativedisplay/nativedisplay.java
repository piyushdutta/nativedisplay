package com.pushnotification.nativedisplay;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.clevertap.android.sdk.displayunits.model.CleverTapDisplayUnit;
import com.clevertap.android.sdk.displayunits.model.CleverTapDisplayUnitContent;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

import static com.pushnotification.nativedisplay.DisplayLauncherActivity.callIntent;


public class nativedisplay{

    public static boolean isnativepayload(ArrayList<CleverTapDisplayUnit> units, Context context)
    {
        boolean template = false;
        String unitid = units.get(0).getUnitID();


        try {
            Log.d("units_custome", units.get(0).getCustomExtras().get("template"));
            String template_1 = units.get(0).getCustomExtras().get("template").toString();
            Log.d("units_custome", units.get(0).getCustomExtras().toString());
            if(template_1.equalsIgnoreCase("true"))
            {
                template =true;

                String custom = units.get(0).getCustomExtras().get("custom ");
//                template = units.get(0).getJsonObject().get("custom_kv").equals("custom");
                if(custom.equalsIgnoreCase("rating"))
                {
                    String title, message;
                    title = units.get(0).getCustomExtras().get("title").toString();
                    message = units.get(0).getCustomExtras().get("message").toString();
                    callIntent(context, unitid,title,message);

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
}