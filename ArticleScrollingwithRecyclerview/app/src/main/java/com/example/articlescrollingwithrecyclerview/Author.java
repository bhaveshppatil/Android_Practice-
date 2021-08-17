package com.example.articlescrollingwithrecyclerview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Author extends AppCompatActivity {

    private TextView tvAuthor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_author);

        tvAuthor = findViewById(R.id.tvAuthor);
        Intent intent = getIntent();
        String author = intent.getStringExtra("Heading");
        tvAuthor.setText(author);
    }
}