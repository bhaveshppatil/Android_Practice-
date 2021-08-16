package com.example.inshortsnewsapp;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

public class NewsViewHolder extends RecyclerView.ViewHolder {

    private TextView tvHeader, tvAuthor, tvDate, tvContent;
    private ImageView ivProfile;
    private Context context;
    private CardView cardView;

    public NewsViewHolder(@NonNull View itemView) {
        super(itemView);
        initView(itemView);
    }

    private void initView(View itemView) {
        tvAuthor = itemView.findViewById(R.id.tvAuthor);
        tvContent = itemView.findViewById(R.id.tvContent);
        tvDate = itemView.findViewById(R.id.tvDate);
        tvHeader = itemView.findViewById(R.id.tvHeader);
        ivProfile = itemView.findViewById(R.id.ivProfile);
        cardView = itemView.findViewById(R.id.newsCardView);

    }

    public void setData(DataModel dataModel, ClickListener clickListener) {

        tvHeader.setText(dataModel.getTitle());
        tvAuthor.setText("Author: " + dataModel.getAuthor());
        tvDate.setText("Date: " + dataModel.getDate());
        tvContent.setText(dataModel.getContent());
        Glide.with(ivProfile).load(dataModel.getImageUrl()).into(ivProfile);

        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               clickListener.onItemClick(dataModel);
            }
        });
    }
}
