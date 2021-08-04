package com.example.eventsdetailfragment.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.eventsdetailfragment.FragmentCommunication;
import com.example.eventsdetailfragment.Model.EventModel;
import com.example.eventsdetailfragment.PreviewDetails;
import com.example.eventsdetailfragment.R;

public class PriceDetailsFragment extends Fragment {

    private FragmentCommunication communication;
    private EditText etCurrency, etPrice;
    private Button btnPreview;
    private String title, description, startDate, endDate, startTime, endTime;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_price_details, container, false);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            title = getArguments().getString("eventTitle");
            description = getArguments().getString("eventDesc");
            startDate = getArguments().getString("startDate");
            endDate = getArguments().getString("endDate");
            startTime = getArguments().getString("startTime");
            endTime = getArguments().getString("endTime");
        }
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews(view);
    }

    private void initViews(View view) {
        etCurrency = view.findViewById(R.id.etCurrency);
        etPrice = view.findViewById(R.id.etPrice);
        btnPreview = view.findViewById(R.id.btnPreview);

        btnPreview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String price = etPrice.getText().toString();
                EventModel eventModel = new EventModel(title, description, startDate, endDate, startTime, endTime, price);
                Intent intent = new Intent(getActivity(), PreviewDetails.class);
                intent.putExtra("eventModel", eventModel);
                startActivity(intent);
            }
        });
    }
}