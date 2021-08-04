package com.example.animaldetails;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AnimalAdapter extends RecyclerView.Adapter<AnimalViewHolder> {

    private ArrayList<AnimalModel> animalModels;
    private ClickListener clickListener;

    public AnimalAdapter(ArrayList<AnimalModel> animalModels, ClickListener clickListener) {
        this.animalModels = animalModels;
        this.clickListener = clickListener;
    }

    @NonNull
    @Override
    public AnimalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.animal_model, parent, false);
        return new AnimalViewHolder(view, clickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull AnimalViewHolder holder, int position) {
        AnimalModel animalModel = animalModels.get(position);
        holder.setData(animalModel);

    }

    @Override
    public int getItemCount() {
        return animalModels.size();
    }
}
