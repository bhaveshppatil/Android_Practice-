package com.example.viewpagertabs;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class DataViewHolder extends RecyclerView.ViewHolder {

    private TextView tvData;
    private Context context;

    public DataViewHolder(@NonNull View itemView) {
        super(itemView);
        tvData = itemView.findViewById(R.id.tvData);
    }

    public void setData(String data) {
        String color1 = "#FF50E3E8";
        String color2 = "#FF68E894";
        if (getAdapterPosition() % 2 == 0) {
            tvData.setText(getAdapterPosition() + " " + data);
            tvData.setBackgroundColor(Color.parseColor(color1));
        }else {
            tvData.setText(getAdapterPosition() + " " + data);
            tvData.setBackgroundColor(Color.parseColor(color2));
        }
    }
}
