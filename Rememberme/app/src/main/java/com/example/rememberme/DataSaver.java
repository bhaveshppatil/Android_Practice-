package com.example.rememberme;

import android.content.Context;
import android.content.SharedPreferences;

public class DataSaver {
    private static final String SHARED_PREFERENCE_KEY = "sharedpreferences";
    private static SharedPreferences sharedPreferences;

    public static SharedPreferences getInstance(Context context) {
        if (sharedPreferences == null) {
            sharedPreferences = context.getSharedPreferences(SHARED_PREFERENCE_KEY, Context.MODE_PRIVATE);
        }
        return sharedPreferences;
    }

    public static void writeIntToPreference(Context context, String key, int value) {
        SharedPreferences.Editor editor = getInstance(context).edit();
        editor.putInt(key, value);
        editor.apply();
    }

    public static void writeStringToPreference(Context context, String key, String value) {
        SharedPreferences.Editor editor = getInstance(context).edit();
        editor.putString(key, value);
        editor.apply();
    }

    public static String getStringFromPreference(Context context, String key) {
        return getInstance(context).getString(key, null);
    }

    public static int getIntFromPreference(Context context, String key) {
        return getInstance(context).getInt(key, 0);
    }
}
