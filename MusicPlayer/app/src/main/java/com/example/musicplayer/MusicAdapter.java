package com.example.musicplayer;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MusicAdapter extends RecyclerView.Adapter<MusicViewHolder> {


    private List<MusicModel> musicModelsList;
    private ClickListener clickListener;

    public MusicAdapter(List<MusicModel> musicModelsList, ClickListener clickListener) {
        this.musicModelsList = musicModelsList;
        this.clickListener = clickListener;
    }


    @NonNull
    @Override
    public MusicViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        return new MusicViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MusicViewHolder holder, int position) {
        MusicModel musicModel = musicModelsList.get(position);
        holder.setData(musicModel, clickListener);
    }

    @Override
    public int getItemCount() {
        return musicModelsList.size();
    }

}
