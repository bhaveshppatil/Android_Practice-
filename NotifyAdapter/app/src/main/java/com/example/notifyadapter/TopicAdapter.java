package com.example.notifyadapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class TopicAdapter extends RecyclerView.Adapter<TopicViewHolder> {
    private ArrayList<TopicModel> topicModelsList;
    private ClickListener clickListener;

    public TopicAdapter(ArrayList<TopicModel> topicModelsList, ClickListener clickListener) {
        this.topicModelsList = topicModelsList;
        this.clickListener = clickListener;
    }

    @NonNull
    @Override
    public TopicViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent,false);
        return new TopicViewHolder(view,clickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull TopicViewHolder holder, int position) {
        TopicModel topicModel = topicModelsList.get(position);
        holder.setData(topicModel);
    }

    @Override
    public int getItemCount() {
        return topicModelsList.size();
    }
}
