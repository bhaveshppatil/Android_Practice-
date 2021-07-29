package com.example.birdsgridview;

import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class BirdViewHolder extends RecyclerView.ViewHolder {

    private ImageView imgBird;
    private CardView cardView;
    private ClickListener clickListener;

    public BirdViewHolder(@NonNull View itemView, ClickListener clickListener) {
        super(itemView);
        this.clickListener = clickListener;
        initViews(itemView);
    }

    private void initViews(View view) {
        imgBird = view.findViewById(R.id.imgBirds);
        cardView = view.findViewById(R.id.crdView);

    }

    public void setData(BirdModel birdModel) {
        imgBird.setImageResource(birdModel.getImgID());
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickListener.onItemClick(birdModel, getAdapterPosition());
            }
        });
    }
}
