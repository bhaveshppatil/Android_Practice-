package com.example.cachegithubresponse.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cachegithubresponse.Model.ResponseModel;
import com.example.cachegithubresponse.R;
import com.example.cachegithubresponse.ViewHolder.GithubViewHolder;

import java.util.List;

public class GithubAdapter extends RecyclerView.Adapter<GithubViewHolder> {
    private List<ResponseModel> responseModelList;

    public GithubAdapter(List<ResponseModel> responseModelList) {
        this.responseModelList = responseModelList;
    }

    @NonNull
    @Override
    public GithubViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.github_item_layout, parent, false);
        return new GithubViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GithubViewHolder holder, int position) {
        ResponseModel responseModel = responseModelList.get(position);
        holder.setData(responseModel);

    }

    @Override
    public int getItemCount() {
        return responseModelList.size();
    }
}
