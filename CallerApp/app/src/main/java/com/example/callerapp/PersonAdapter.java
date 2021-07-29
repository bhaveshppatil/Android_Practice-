package com.example.callerapp;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class PersonAdapter extends RecyclerView.Adapter<PersonViewHolder> {

    private List<PersonModel> personModelList = new ArrayList<>();
    private ClickListener clickListener;

    public PersonAdapter(List<PersonModel> personModelList, ClickListener clickListener) {
        this.personModelList = personModelList;
        this.clickListener = clickListener;
    }


    @NonNull
    @Override
    public PersonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        return new PersonViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PersonViewHolder holder, int position) {
        PersonModel personModel = personModelList.get(position);
        holder.setData(personModel, clickListener);
    }

    @Override
    public int getItemCount() {
        return personModelList.size();
    }
}
