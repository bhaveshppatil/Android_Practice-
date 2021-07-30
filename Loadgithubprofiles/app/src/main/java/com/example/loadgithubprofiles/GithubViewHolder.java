package com.example.loadgithubprofiles;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;


public class GithubViewHolder extends RecyclerView.ViewHolder {
    private TextView tvUsername;
    private TextView tvLogin;
    private ImageView ivProfile;

    public GithubViewHolder(@NonNull View itemView) {
        super(itemView);
        initView(itemView);
    }

    private void initView(View itemView) {
        tvUsername = itemView.findViewById(R.id.tvUsername);
        tvLogin = itemView.findViewById(R.id.tvLogin);
        ivProfile = itemView.findViewById(R.id.ivProfile);
    }

    public void setData(ResponseModel responseModel){
       tvUsername.setText(responseModel.getFullName());
       tvLogin.setText(responseModel.getOwner().getLogin());

       if (responseModel.getOwner().getAvatarUrl() == null){
           ivProfile.setImageResource(R.drawable.bill_gates);
       }else {
           Glide.with(ivProfile).load(responseModel.getOwner().getAvatarUrl()).into(ivProfile);
       }
    }
}
