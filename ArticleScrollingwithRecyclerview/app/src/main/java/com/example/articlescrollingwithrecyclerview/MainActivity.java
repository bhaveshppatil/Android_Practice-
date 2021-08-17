package com.example.articlescrollingwithrecyclerview;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ItemClickListener {

    private ArrayList<Article> articlesList;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);

        buildData();
        setViewData();
    }

    private void setViewData() {
        ArticleAdapter articleAdapter = new ArticleAdapter(articlesList, this);
        GridLayoutManager layoutManager = new GridLayoutManager(MainActivity.this, 2);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(articleAdapter);
    }


    public void buildData() {
        articlesList = new ArrayList<>();
        articlesList.add(new Article(R.drawable.bgmi_official_release,
                "Battlegrounds Mobile India Officially Released on Android, Krafton Thanks Players for 10 Million Downloads",
                "Battlegrounds Mobile India pre-registrations started on May 18 and a month later it was in early access phase"));
        articlesList.add(new Article(R.drawable.whatsapp_892926_1920,
                "WhatsApp to soon allow you to select video quality",
                "WhatsApp is soon expected to allow you to select video quality before sharing it with anyone"));
        articlesList.add(new Article(R.drawable.aritel,
                "Airtel Black plans launched in India",
                "Bharti Airtel today launched a new all-in-one solution for its subscribers in India"));
        articlesList.add(new Article(R.drawable.tiktok,
                "TikTok removes six million videos in Pakistan to tackle ban",
                "A spokesman said the Pakistan-made videos were banned as a result of both user and government requests"));
        articlesList.add(new Article(R.drawable.wally_reuters_1625211453056,
                "Trailblazing Female Pilot Will Go to Space at Age 82 With Jeff Bezos",
                "Wally Funk will be the oldest person ever to travel into space"));
        articlesList.add(new Article(R.drawable.samsung_galaxy_z_fold_3,
                "Samsung Galaxy Z Fold 3 Camera Details Surface Online",
                "Samsung Galaxy Z Fold 3 is expected to feature three 12-megapixel sensors in its triple rear camera setup"));
    }


    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(MainActivity.this, Author.class);
        intent.putExtra("Heading", articlesList.get(position).getTvContent());
        startActivity(intent);
    }
}