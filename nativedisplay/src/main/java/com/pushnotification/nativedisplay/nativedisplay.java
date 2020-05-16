package com.pushnotification.nativedisplay;

import android.util.Log;

import com.clevertap.android.sdk.displayunits.model.CleverTapDisplayUnit;
import com.clevertap.android.sdk.displayunits.model.CleverTapDisplayUnitContent;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class nativedisplay{



    public static boolean isnativepayload(ArrayList<CleverTapDisplayUnit> units)
    {
        boolean template = false;
        String unitid = units.get(0).getUnitID();


        try {
            Log.d("units_custome", units.get(0).getCustomExtras().get("template"));
            String template_1 = units.get(0).getCustomExtras().get("template").toString();

            if(template_1.equalsIgnoreCase("true"))
            {
                template =true;
                String custom = "";
                template = units.get(0).getJsonObject().get("custom_kv").equals("custom");
                if(custom.equalsIgnoreCase("rating"))
                {
                    String title, message;
                }
                else
                {
                    return template;
                }

            }

        }catch (Exception e)
        {}

        return template;

    }
}