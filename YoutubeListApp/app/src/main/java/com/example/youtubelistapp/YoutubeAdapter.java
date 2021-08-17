package com.example.youtubelistapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class YoutubeAdapter extends RecyclerView.Adapter<YoutubeViewHolder> {
    private List<YoutubeModel> youtubeModelList = new ArrayList<>();
    private ClickListener clickListener;

    public YoutubeAdapter(List<YoutubeModel> youtubeModelList, ClickListener clickListener) {
        this.youtubeModelList = youtubeModelList;
        this.clickListener = clickListener;
    }

    @NonNull
    @Override
    public YoutubeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        return new YoutubeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull YoutubeViewHolder holder, int position) {
        YoutubeModel youtubeModel = youtubeModelList.get(position);
        holder.setData(youtubeModel, clickListener);

    }

    @Override
    public int getItemCount() {
        return youtubeModelList.size();
    }
}
