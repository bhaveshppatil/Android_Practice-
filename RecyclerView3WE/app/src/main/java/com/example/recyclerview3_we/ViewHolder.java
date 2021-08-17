package com.example.recyclerview3_we;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class ViewHolder extends RecyclerView.ViewHolder {

    private TextView tvName;
    private TextView tvAge;
    private TextView tvAddress;
    private ImageView imgEdit;
    private CardView cardView;
    private ClickListener clickListener;

    public ViewHolder(@NonNull View itemView, ClickListener clickListener) {
        super(itemView);
        this.clickListener = clickListener;
        initViews(itemView);
    }

    private void initViews(View itemView) {
        tvName = itemView.findViewById(R.id.tvName);
        tvAge = itemView.findViewById(R.id.tvAge);
        tvAddress = itemView.findViewById(R.id.tvAddress);
        imgEdit = itemView.findViewById(R.id.imgEdit);
        cardView = itemView.findViewById(R.id.editCrdView);

    }

    public void setData(Model model) {
        tvName.setText(model.getName());
        tvAge.setText(model.getAge()+ "");
        tvAddress.setText(model.getAddress());
        imgEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickListener.onItemClick(getAdapterPosition(), model);
            }
        });
    }

}
