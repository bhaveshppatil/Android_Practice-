package com.example.youtubelistapp;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ClickListener {

    private List<YoutubeModel> youtubeModelList = new ArrayList<>();
    private ClickListener clickListener;
    private TextView tvTitle;
    private ImageView ivThumbnail;
    private RecyclerView recyclerView;
    private CardView cardView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        buildData();
        setRecyclerView();

    }

    private void initViews() {
        tvTitle = findViewById(R.id.tvTitle);
        ivThumbnail = findViewById(R.id.ivThumbnail);
        recyclerView = findViewById(R.id.recyclerView);
        cardView = findViewById(R.id.cardView);

    }

    public void buildData() {
        youtubeModelList.add(new YoutubeModel(R.drawable.amit, "Father Saab ( Official Video ) - Amit Bhadana | King | Section 8 | Teji Sandhu", "mHJ4qZIUUFk"));
        youtubeModelList.add(new YoutubeModel(R.drawable.download, "OnePlus Nord 2 5G Unboxing And First Impressions ⚡ Dimensity 1200, 90Hz AMOLED, 50MP Camera & More", "DC1s30q1jPs"));
        youtubeModelList.add(new YoutubeModel(R.drawable.emiway, "EMIWAY BANTAI - PAANI MAI | SWAALINA | YOUNG GALIB | (OFFICIAL MUSIC VIDEO)", "uYoPUKFM2VE"));
        youtubeModelList.add(new YoutubeModel(R.drawable.game, "Solo vs Squad 21 Kill Dragunov and Mp40 OverPower Gameplay - Garena Free Fire", "_MHUYPV83WY"));
        youtubeModelList.add(new YoutubeModel(R.drawable.masai, "Is coding right for you? | Attend the Masai Coding Workshop to find out.", "rqQGp0l30lI"));
        youtubeModelList.add(new YoutubeModel(R.drawable.mirabai, "Mirabai Chanu wins silver for India | Weightlifting | #Tokyo2020 Highlights", "ssEzTsg0reE"));
        youtubeModelList.add(new YoutubeModel(R.drawable.work, "Wake Up & Work For It, Don't Stop Now - The Ultimate Study Motivation", "7YSm6iMS6r0"));
        youtubeModelList.add(new YoutubeModel(R.drawable.trailer, "Shershaah - Official Trailer | Vishnu Varadhan | Sidharth Malhotra, Kiara Advani | Aug 12", "Q0FTXnefVBA"));
        youtubeModelList.add(new YoutubeModel(R.drawable.song, "Barsaat Ki Dhun Song | Rochak K Ft. Jubin N | Gurmeet C, Karishma S |Rashmi V | Ashish P | Bhushan K", "YIucrdfR6rI"));
        youtubeModelList.add(new YoutubeModel(R.drawable.nadkhula, "Mi Naadkhula | Vishal Phale | Pratibha Joshi | Adarsh Shinde | Sonali Sonawane | Prashant Nakti", "w2qogQLWEqI"));
        youtubeModelList.add(new YoutubeModel(R.drawable.yamaha, "2020 Yamaha R15 v3 BS6 Detailed Ride Review | Mileage | Price | Nitish Neo", "ThbKTyloNyw"));

    }

    private void setRecyclerView() {
        YoutubeAdapter youtubeAdapter = new YoutubeAdapter(youtubeModelList, this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setAdapter(youtubeAdapter);
        recyclerView.setLayoutManager(layoutManager);
    }

    @Override
    public void onItemClicked(YoutubeModel model) {

        String uri = model.getUri().toString();
        Intent webIntent = new Intent(Intent.ACTION_VIEW,
                Uri.parse("https://www.youtube.com/watch?v=" + uri));
        try {
            MainActivity.this.startActivity(webIntent);
        } catch (ActivityNotFoundException ex) {
        }
    }
}