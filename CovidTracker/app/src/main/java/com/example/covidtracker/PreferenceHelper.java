package com.example.covidtracker;

import android.content.Context;
import android.content.SharedPreferences;

public class PreferenceHelper {

    private static final String SHARED_PREFERENCE_KEY = "com.xyz.sharedpreferences";

    public static SharedPreferences getSharedPreferences(Context context) {
    return context.getSharedPreferences(SHARED_PREFERENCE_KEY, Context.MODE_PRIVATE);
    }
    public static void writeIntToPreference(Context context, String key, int value){
        SharedPreferences.Editor editor = getSharedPreferences(context).edit();
        editor.putInt(key, value);
        editor.apply();
    }
    public static void writeStringToPreference(Context context, String key, String value) {
        SharedPreferences.Editor editor = getSharedPreferences(context).edit();
        editor.putString(key, value);
        editor.apply();
    }
    public static String getStringFromPreference(Context context, String key) {
        return getSharedPreferences(context).getString(key, null);
    }
}
