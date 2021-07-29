package com.example.birdsgridview;

import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ClickListener {
    private RecyclerView recyclerView;
    private ArrayList<BirdModel> birdModels;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initVies();
        buildBirdData();
        setRecyclerView();
    }

    private void initVies() {
        recyclerView = findViewById(R.id.rclView);
    }

    private void setRecyclerView() {
        BirdAdapter birdAdapter = new BirdAdapter(birdModels, this);
        GridLayoutManager layoutManager = new GridLayoutManager(MainActivity.this, 4, RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(birdAdapter);
    }

    private void buildBirdData() {
        birdModels = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            if (i % 4 == 0) {
                birdModels.add(new BirdModel(R.drawable.parrot, "Parrot"));
            } else if (i % 4 == 1) {
                birdModels.add(new BirdModel(R.drawable.peacock, "Peafowl"));
            } else if (i % 4 == 2) {
                birdModels.add(new BirdModel(R.drawable.pigeons, "Pigeons"));
            } else if (i % 4 == 3) {
                birdModels.add(new BirdModel(R.drawable.bald_eagle, "Eagle"));
            }
        }
    }

    @Override
    public void onItemClick(BirdModel birdModel, int position) {

        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        alertDialog.setTitle(birdModel.getBirdName())
                .setIcon(birdModel.getImgID())
                .show();
    }
}