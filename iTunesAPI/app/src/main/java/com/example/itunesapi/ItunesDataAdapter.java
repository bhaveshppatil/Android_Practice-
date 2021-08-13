package com.example.itunesapi;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.itunesapi.Model.ResultsModel;

import java.util.List;

public class ItunesDataAdapter extends RecyclerView.Adapter<itunesDataHolder> {

    private List<ResultsModel> resultsModelList;
    private ClickListener clickListener;

    public ItunesDataAdapter(List<ResultsModel> resultsModelList, ClickListener clickListener) {
        this.resultsModelList = resultsModelList;
        this.clickListener = clickListener;
    }


    @NonNull
    @Override
    public itunesDataHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.itunes_item_layout, parent, false);
        return new itunesDataHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull itunesDataHolder holder, int position) {
        ResultsModel resultsModel = resultsModelList.get(position);
        holder.setData(resultsModel, clickListener);
    }

    @Override
    public int getItemCount() {
        return resultsModelList.size();
    }
}
