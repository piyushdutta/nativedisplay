package com.pushnotification.nativedisplay;

import android.util.Log;

import com.clevertap.android.sdk.displayunits.model.CleverTapDisplayUnit;
import com.clevertap.android.sdk.displayunits.model.CleverTapDisplayUnitContent;

import java.util.ArrayList;
import java.util.HashMap;

public class nativedisplay{



    public static boolean isnativepayload(ArrayList<CleverTapDisplayUnit> units)
    {
        boolean template = false;
        String unitid = units.get(0).getUnitID();


        try {
            Log.d("units_custome", units.get(0).getJsonObject().get("custom_kv").toString());

            template = units.get(0).getJsonObject().get("custom_kv").equals("template");

            if(template)
            {
                String custom = "";
                template = units.get(0).getJsonObject().get("custom_kv").equals("custom");
                if(custom.equalsIgnoreCase("rating"))
                {
                    String title, message;
                }
                else
                {
                    template = false ;
                }

            }

        }catch (Exception e)
        {}

        return template;

        //"custom_kv":{"custom ":"rating","title":"hello","message":"world","template":"true"}
    }
}