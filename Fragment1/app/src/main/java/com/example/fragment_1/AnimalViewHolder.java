package com.example.fragment_1;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class AnimalViewHolder extends RecyclerView.ViewHolder {

    private TextView tvName;
    private ImageView picture;
    private CardView cardView;

    public AnimalViewHolder(@NonNull View itemView) {
        super(itemView);
        initView(itemView);

    }

    private void initView(View itemView) {
        tvName = itemView.findViewById(R.id.tvName);
        picture = itemView.findViewById(R.id.picture);
        cardView = itemView.findViewById(R.id.cardView);
    }

    public void setData(AnimalModel model) {
        tvName.setText(model.getTvName());
        picture.setImageResource(model.getResID());

    }
}
