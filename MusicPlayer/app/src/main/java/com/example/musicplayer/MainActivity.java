package com.example.musicplayer;

import android.content.Context;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ClickListener {

    MusicModel musicModel;
    private RecyclerView recyclerView;
    private ClickListener clickListener;
    private TextView tvDurationStart, tvDurationEnd;
    private List<MusicModel> musicModelList = new ArrayList<>();
    private SeekBar seekBar;
    private MusicAdapter musicAdapter;
    private Context AppContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        tvDurationEnd = findViewById(R.id.tvDurationTotal);
        seekBar = findViewById(R.id.seekbar);
        buildData();
        setRecyclerView();
    }

    public void setRecyclerView() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        musicAdapter = new MusicAdapter(musicModelList, this);
        recyclerView.setAdapter(musicAdapter);
        recyclerView.setLayoutManager(layoutManager);
    }

    public void buildData() {

        musicModelList.add(new MusicModel("On My Way", "0.00", R.raw.onmyway, R.drawable.on_my_way));
        musicModelList.add(new MusicModel("Lean On", "0.00", R.raw.leanon, R.drawable.lean_on));
        musicModelList.add(new MusicModel("Peaches", "0.00", R.raw.peaches, R.drawable.peaches));
        musicModelList.add(new MusicModel("Believer", "0.00", R.raw.believer, R.drawable.believer));
        musicModelList.add(new MusicModel("On My Way", "0.00", R.raw.onmyway2, R.drawable.on_my_way));
        musicModelList.add(new MusicModel("Shankara", "0.00", R.raw.shankara, R.drawable.shankara));
        musicModelList.add(new MusicModel("Peaches", "0.00", R.raw.peaches, R.drawable.peaches));
        musicModelList.add(new MusicModel("Believer", "0.00", R.raw.believer, R.drawable.believer));
        musicModelList.add(new MusicModel("On My Way", "0.00", R.raw.onmyway, R.drawable.on_my_way));
        musicModelList.add(new MusicModel("Shankara", "0.00", R.raw.shankara, R.drawable.shankara));
        musicModelList.add(new MusicModel("Peaches", "0.00", R.raw.peaches, R.drawable.peaches));
        musicModelList.add(new MusicModel("Believer", "0.00", R.raw.believer, R.drawable.believer));
    }


    @Override
    public void onItemClick(MusicModel musicModel) {
    }

    @Override
    public void remove(MusicModel musicModel) {
        musicModelList.remove(musicModel);
        musicAdapter.notifyDataSetChanged();
    }
}