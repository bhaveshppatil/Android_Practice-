package com.example.eventbooking;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.Editable;

public class DataSaver {
    private static final String DATA_NAME = "database";
    private static SharedPreferences sharedPreferences;

    public static SharedPreferences getInstance(Context context) {
        if (sharedPreferences == null) {
            sharedPreferences = context.getSharedPreferences(DATA_NAME, Context.MODE_PRIVATE);
        }
        return sharedPreferences;
    }

    public static void editIntToPreference(String key, int value) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(key, value);
        editor.apply();
    }

    public static void editStringToPreference(String key, String value) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key, value);
        editor.apply();
    }

    public static void editLongToPreference(String key, Long value){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putLong(key, value);
        editor.apply();
    }

    public static long getLong(String key) {
        return sharedPreferences.getLong(key, 0);
    }

    public static int getInt(String key) {
        return sharedPreferences.getInt(key, 0);
    }

    public static String getString(String key) {
        return sharedPreferences.getString(key, "");
    }
}
