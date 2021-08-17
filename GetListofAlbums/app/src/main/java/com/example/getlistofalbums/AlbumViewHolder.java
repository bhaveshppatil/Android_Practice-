package com.example.getlistofalbums;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AlbumViewHolder extends RecyclerView.ViewHolder {
    private TextView tvUserID, tvTitle, tvID;


    public AlbumViewHolder(@NonNull View itemView) {
        super(itemView);
        initView(itemView);

    }

    private void initView(View itemView) {
        tvUserID = itemView.findViewById(R.id.tvUserID);
        tvTitle = itemView.findViewById(R.id.tvTitle);
        tvID = itemView.findViewById(R.id.tvID);
    }

    public void setAlbumData(ResponseModel responseModel) {
        tvUserID.setText("User ID: "+responseModel.getUserId() + "");
        tvID.setText("ID: "+ responseModel.getId() + "");
        tvTitle.setText("Title: "+responseModel.getTitle());
    }
}
