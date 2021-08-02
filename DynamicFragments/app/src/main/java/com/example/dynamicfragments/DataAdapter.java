package com.example.dynamicfragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class DataAdapter extends RecyclerView.Adapter<DataViewHolder> {
    private List<ResponseModel> responseModelList;

    public DataAdapter(List<ResponseModel> responseModelList) {
        this.responseModelList = responseModelList;
    }

    @NonNull
    @Override
    public DataViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.data_item_layout, parent, false);
        return new DataViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DataViewHolder holder, int position) {
        ResponseModel responseModel = responseModelList.get(position);
        holder.setData(responseModel);
    }

    @Override
    public int getItemCount() {
        return responseModelList.size();
    }
    public void updateData(List<ResponseModel> responseModelList1){
        this.responseModelList = responseModelList1;
        notifyDataSetChanged();
    }
}
