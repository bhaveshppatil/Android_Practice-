package com.example.postrequest;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
    private TextView tvTitle, tvRequest, tvPasswd, tvEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        tvEmail = findViewById(R.id.tvEmail);
        tvPasswd = findViewById(R.id.tvPasswd);
        tvRequest = findViewById(R.id.tvRequestType);
        tvTitle = findViewById(R.id.tvTitle);
        Intent intent = getIntent();

        int id = intent.getIntExtra("id", 0);
        String email = intent.getStringExtra("email");
        String title = intent.getStringExtra("title");
        String request = intent.getStringExtra("request");

        tvTitle.setText("Title: " + title);
        tvEmail.setText("Email:" + email);
        tvRequest.setText("Request Type: " + request);
        tvPasswd.setText("ID: " + id);

    }
}