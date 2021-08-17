package com.example.youtubelistapp;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class YoutubeViewHolder extends RecyclerView.ViewHolder {

    private TextView tvTitle;
    private ImageView ivThumbnail;
    private CardView cardView;

    public YoutubeViewHolder(@NonNull View itemView) {
        super(itemView);
        initViews(itemView);
    }

    private void initViews(View itemView) {
        tvTitle = itemView.findViewById(R.id.tvTitle);
        ivThumbnail = itemView.findViewById(R.id.ivThumbnail);
        cardView = itemView.findViewById(R.id.cardView);

    }

    public void setData(YoutubeModel model, ClickListener clickListener){

        tvTitle.setText(model.getTitle());
        ivThumbnail.setImageResource(model.getResID());

        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickListener.onItemClicked(model);

            }
        });
    }
}
