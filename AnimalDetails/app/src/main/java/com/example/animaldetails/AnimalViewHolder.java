package com.example.animaldetails;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class AnimalViewHolder extends RecyclerView.ViewHolder {
    private TextView tvName;
    private TextView tvSound;
    private ImageView imgAnimal;
    private ClickListener clickListener;
    private CardView cardView;


    public AnimalViewHolder(@NonNull View itemView, ClickListener clickListener) {
        super(itemView);
        this.clickListener = clickListener;
        initViews(itemView);
    }
    private void initViews(View view){
        tvName = view.findViewById(R.id.tvName);
        tvSound = view.findViewById(R.id.tvSound);
        cardView = view.findViewById(R.id.crdView);
        imgAnimal = view.findViewById(R.id.imgAnimal);
    }
    public void setData(AnimalModel model){
        imgAnimal.setImageResource(model.getImgID());
        tvName.setText(model.getTvName());
        tvSound.setText(model.getTvSound());
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickListener.onClick(getAdapterPosition(), model);
            }
        });
    }
}
