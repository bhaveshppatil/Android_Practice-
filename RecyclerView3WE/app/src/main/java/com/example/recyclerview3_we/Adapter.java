package com.example.recyclerview3_we;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<ViewHolder> {

    private ArrayList<Model> modelsList;
    private ClickListener clickListener;


    public Adapter(ArrayList<Model> modelsList, ClickListener clickListener) {
        this.modelsList = modelsList;
        this.clickListener = clickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        return new ViewHolder(view, clickListener);
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Model model = modelsList.get(position);
        holder.setData(model);
    }

    @Override
    public int getItemCount() {
        return modelsList.size();
    }
}