package com.example.dynamicfragments;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

public class DataViewHolder extends RecyclerView.ViewHolder {
    private ImageView ivProfile;
    private TextView tvTitle, tvSubtitle;


    public DataViewHolder(@NonNull View itemView) {
        super(itemView);
        initView(itemView);
    }

    private void initView(View itemView) {
        ivProfile = itemView.findViewById(R.id.ivPicture);
        tvTitle = itemView.findViewById(R.id.tvTitle);
        tvSubtitle = itemView.findViewById(R.id.tvSubTitle);
    }
    public void setData(ResponseModel model){
        Glide.with(ivProfile).load(model.getImage()).into(ivProfile);
        tvTitle.setText("Title: "+model.getTitle());
        tvSubtitle.setText("Subtitle: "+model.getSubTitle());
    }
}
