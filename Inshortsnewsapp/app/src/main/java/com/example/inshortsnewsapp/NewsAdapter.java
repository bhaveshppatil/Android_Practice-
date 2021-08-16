package com.example.inshortsnewsapp;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsViewHolder> {

    private List<DataModel> dataModelList;
    private Context context;
    private ClickListener clickListener;

    public NewsAdapter(List<DataModel> dataModelList, ClickListener clickListener) {
        this.dataModelList = dataModelList;
        this.clickListener = clickListener;
    }

    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_item_layout, parent, false);
        return new NewsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder holder, int position) {
        DataModel dataModel = dataModelList.get(position);
        holder.setData(dataModel, clickListener);
    }

    @Override
    public int getItemCount() {
        return dataModelList.size();
    }

    public void updateData(List<DataModel> dataModelList) {
        this.dataModelList = dataModelList;
        notifyDataSetChanged();
    }
}
