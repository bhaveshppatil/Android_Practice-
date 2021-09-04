package com.example.cachegithubresponse.ViewHolder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.cachegithubresponse.Model.ResponseModel;
import com.example.cachegithubresponse.R;

public class GithubViewHolder extends RecyclerView.ViewHolder {
    private TextView tvUsername, tvLoginId, tvDecs;
    private ImageView ivGitProfile;


    public GithubViewHolder(@NonNull View itemView) {
        super(itemView);
        initViews(itemView);
    }

    private void initViews(View itemView) {

        tvUsername = itemView.findViewById(R.id.tvUsername);
        tvDecs = itemView.findViewById(R.id.tvDecs);
        tvLoginId = itemView.findViewById(R.id.tvLogin);
        ivGitProfile = itemView.findViewById(R.id.ivProfile);

    }

    public void setData(ResponseModel responseModel) {
        tvUsername.setText(responseModel.getName());
        tvLoginId.setText(responseModel.getOwner().getLogin());
        tvDecs.setText(responseModel.getDescription());
        Glide.with(ivGitProfile).load(responseModel.getOwner().getAvatarUrl()).into(ivGitProfile);
    }
}
