package com.example.fragment_1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class AnimalAdapter extends RecyclerView.Adapter<AnimalViewHolder> {
    private List<AnimalModel> animalModelList = new ArrayList<>();

    public AnimalAdapter(List<AnimalModel> animalModelList) {
        this.animalModelList = animalModelList;
    }

    @NonNull
    @Override
    public AnimalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.animal_item_layout, parent, false);
        return new AnimalViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AnimalViewHolder holder, int position) {
        AnimalModel animalModel = animalModelList.get(position);
        holder.setData(animalModel);
    }

    @Override
    public int getItemCount() {
        return animalModelList.size();
    }
}
