package com.example.birdsgridview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class BirdAdapter extends RecyclerView.Adapter<BirdViewHolder> {

    private ArrayList<BirdModel> birdList;
    private ClickListener clickListener;

    public BirdAdapter(ArrayList<BirdModel> birdList, ClickListener clickListener) {
        this.birdList = birdList;
        this.clickListener = clickListener;
    }

    @NonNull
    @Override
    public BirdViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.bird_view, parent, false);

        return new BirdViewHolder(view, clickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull BirdViewHolder holder, int position) {
        BirdModel birdModel = birdList.get(position);
        holder.setData(birdModel);
    }

    @Override
    public int getItemCount() {
        return birdList.size();
    }
}
