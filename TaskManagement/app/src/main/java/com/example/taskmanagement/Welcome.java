package com.example.taskmanagement;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

public class Welcome extends AppCompatActivity {

    CardView crdMeeting, crdGradle, crdDevelopment, crdBackDevelop;
    TextView tvUpdate, tvDelete, tvUpdate2, tvUpdate3, tvDelete2, tvDelete3, tvUpdate4, tvDelete4;
    View lyMeeting;
    View lyGradle;
    View lyDevelopment;
    View lyBackDevelop;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome2);

        crdMeeting = findViewById(R.id.crdMeeting);
        tvUpdate = findViewById(R.id.tvUpdate);
        tvDelete = findViewById(R.id.tvDelete);
        lyMeeting = findViewById(R.id.lyMeeting);
        lyGradle = findViewById(R.id.lyGradle);
        lyDevelopment = findViewById(R.id.lyDevelopment);
        lyBackDevelop = findViewById(R.id.lyBackDevelop);
        crdBackDevelop = findViewById(R.id.crdBackEndDevelop);
        toolbar = findViewById(R.id.addTask);

        crdGradle = findViewById(R.id.crdGradle);
        crdDevelopment = findViewById(R.id.crdDevelopment);
        tvDelete2 = findViewById(R.id.tvDelete2);
        tvDelete3 = findViewById(R.id.tvDelete3);
        tvUpdate2 = findViewById(R.id.tvUpdate2);
        tvUpdate3 = findViewById(R.id.tvUpdate3);
        tvDelete4 = findViewById(R.id.tvDelete4);
        tvUpdate4 = findViewById(R.id.tvUpdate4);

        lyMeeting.setVisibility(View.GONE);
        lyGradle.setVisibility(View.GONE);
        lyDevelopment.setVisibility(View.GONE);
        lyBackDevelop.setVisibility(View.GONE);

        toolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Welcome.this, createNewTask.class);
                startActivity(intent);
            }
        });

        crdMeeting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lyMeeting.setVisibility(View.VISIBLE);
            }
        });


        crdGradle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lyGradle.setVisibility(View.VISIBLE);
            }
        });

        crdDevelopment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lyDevelopment.setVisibility(View.VISIBLE);
            }
        });

        crdBackDevelop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lyBackDevelop.setVisibility(View.VISIBLE);
            }
        });

    }
}