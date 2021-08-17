package com.example.rememberme;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class UserData extends AppCompatActivity {
    private TextView tvUserName;
    private static final String FILE_NAME = "myFile";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_data);
        tvUserName = findViewById(R.id.tvUserName);
        SharedPreferences sharedPreferences = getSharedPreferences(FILE_NAME, MODE_PRIVATE);
        String name = sharedPreferences.getString("name", "");
        tvUserName.setText(name);
    }
}