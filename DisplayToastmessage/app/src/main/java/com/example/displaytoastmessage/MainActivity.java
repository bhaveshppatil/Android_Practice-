package com.example.displaytoastmessage;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button btnFirst, btnSecond, btnThird;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnFirst = findViewById(R.id.btnFirst);
        btnSecond = findViewById(R.id.btnSecond);
        btnThird = findViewById(R.id.btnThird);

        btnFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Button one clicked", Toast.LENGTH_SHORT).show();
            }
        });

        btnSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Button Two clicked", Toast.LENGTH_SHORT).show();

            }
        });

        btnThird.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Button Three clicked", Toast.LENGTH_SHORT).show();

            }
        });

    }
}