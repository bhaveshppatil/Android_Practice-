package com.example.callerapp;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class PersonViewHolder extends RecyclerView.ViewHolder {


    private TextView tvPName, tvPNumber;
    private CardView cardView;
    private ImageView pAvatar;

    public PersonViewHolder(@NonNull View itemView) {
        super(itemView);
        initViews(itemView);
    }

    private void initViews(View itemView) {
        tvPName = itemView.findViewById(R.id.tvPersonName);
        tvPNumber = itemView.findViewById(R.id.tvContactNo);
        pAvatar = itemView.findViewById(R.id.ContactProfile);
        cardView = itemView.findViewById(R.id.cardView);
    }

    public void setData(PersonModel personModel, ClickListener clickListener) {

        tvPName.setText(personModel.getTvPName());
        tvPNumber.setText(personModel.getTvPNumber()+"");
        pAvatar.setImageResource(personModel.getResID());

        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickListener.onItemClicked(personModel);
            }
        });

    }
}
