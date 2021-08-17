package com.example.covidtracker;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class CovidViewHolder extends RecyclerView.ViewHolder {

    private TextView date, positive, negative, hospitalizedCurrently, onVentilatorCurrently, death, dateChecked;
    private CardView cardView;
    private Context context;

    private ClickListener clickListener;


    public CovidViewHolder(@NonNull View itemView, ClickListener clickListener) {
        super(itemView);
        this.clickListener = clickListener;
        initViews(itemView);
    }

    private void initViews(View itemView) {
        date = itemView.findViewById(R.id.date);
        positive = itemView.findViewById(R.id.positive);
        negative = itemView.findViewById(R.id.negative);
        hospitalizedCurrently = itemView.findViewById(R.id.hospitalizedCurrently);
        onVentilatorCurrently = itemView.findViewById(R.id.onVentilatorCurrently);
        death = itemView.findViewById(R.id.death);
        dateChecked = itemView.findViewById(R.id.dateChecked);
        cardView = itemView.findViewById(R.id.crdView);
    }

    public void setCovidData(ResponseModel responseModel) {

        date.setText("Date: " + responseModel.getDate() + "");
        positive.setText("Positive: " + responseModel.getPositive() + "");
        negative.setText("Negative: " + responseModel.getNegative() + "");
        hospitalizedCurrently.setText("Hospitalized Currently: " + responseModel.getHospitalizedCurrently() + "");
        onVentilatorCurrently.setText("On Ventilator Currently: " + responseModel.getOnVentilatorCurrently() + "");
        date.setText("Death: " + responseModel.getDeath() + "");
        dateChecked.setText("Date Checked: " + responseModel.getDateChecked() + "");
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickListener.onItemClick(getAdapterPosition(), responseModel);
            }
        });
    }
}
