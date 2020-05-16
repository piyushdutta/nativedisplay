package com.pushnotification.nativedisplay;

import android.util.Log;

import com.clevertap.android.sdk.displayunits.model.CleverTapDisplayUnit;
import com.clevertap.android.sdk.displayunits.model.CleverTapDisplayUnitContent;

import java.util.ArrayList;
import java.util.HashMap;

public class nativedisplay{



    public static boolean isnativepayload(ArrayList<CleverTapDisplayUnit> units)
    {

        Log.d("units", units.get(0).toString());

        ArrayList<CleverTapDisplayUnitContent> contents;

        contents.addAll(unit.contents)
        contents= units.get(0).getContents();

        Log.e("contents",contents.toString());

        //data.get("custom_kv")

        for(int i =0 ; i< units.get(0).getCustomExtras().size();i++)
        {
            Log.e("native data",units.get(0).getUnitID());
        }

        return false;

        //"custom_kv":{"custom ":"rating","title":"hello","message":"world","template":"true"}
    }
}