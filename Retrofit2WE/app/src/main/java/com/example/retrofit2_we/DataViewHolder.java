package com.example.retrofit2_we;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class DataViewHolder extends RecyclerView.ViewHolder {
    private TextView tvName, tvEmail, tvBody;

    public DataViewHolder(@NonNull View itemView) {
        super(itemView);
        initViews(itemView);

    }

    private void initViews(View itemView) {
        tvName = itemView.findViewById(R.id.tvName);
        tvEmail = itemView.findViewById(R.id.tvEmail);
        tvBody = itemView.findViewById(R.id.tvBody);

    }
    public void setData(ResponseModel responseModel){
        tvName.setText("Name: "+responseModel.getName());
        tvEmail.setText("Email: "+responseModel.getEmail());
        tvBody.setText("Body: "+responseModel.getBody());

    }
}
