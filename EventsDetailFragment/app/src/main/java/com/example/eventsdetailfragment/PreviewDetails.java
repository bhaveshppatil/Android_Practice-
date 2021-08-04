package com.example.eventsdetailfragment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.eventsdetailfragment.Model.EventModel;

public class PreviewDetails extends AppCompatActivity {

    private TextView tvTitle, tvDescription, tvStartDate, tvEndDate, tvStartTime, tvEndTime, tvPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preview_details);
        initViews();
    }

    private void initViews() {
        tvTitle = findViewById(R.id.tvTitleData);
        tvDescription = findViewById(R.id.tvDesrpData);
        tvStartDate = findViewById(R.id.tvStartDateData);
        tvEndDate = findViewById(R.id.tvEndDateData);
        tvStartTime = findViewById(R.id.tvStartTimeData);
        tvEndTime = findViewById(R.id.tvEndTimeData);
        tvPrice = findViewById(R.id.tvPriceData);

        EventModel eventModel = (EventModel) getIntent().getSerializableExtra("eventModel");
        tvTitle.setText("Event Title: "+eventModel.getTitle());
        tvDescription.setText("Event Desc: "+eventModel.getDescription());
        tvStartDate.setText("Event start date: "+eventModel.getStartDate());
        tvEndDate.setText("Event end date: "+eventModel.getEndDate());
        tvStartTime.setText("Event start time: "+eventModel.getStartTime());
        tvEndTime.setText("Event end time: "+eventModel.getEndTime());
        tvPrice.setText("Event Price: "+eventModel.getPrice());

    }
}