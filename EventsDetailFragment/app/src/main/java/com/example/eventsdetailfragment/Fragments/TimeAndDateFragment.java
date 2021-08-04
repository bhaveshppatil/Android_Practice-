package com.example.eventsdetailfragment.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.eventsdetailfragment.FragmentCommunication;
import com.example.eventsdetailfragment.R;

public class TimeAndDateFragment extends Fragment {

    private FragmentCommunication communication;
    private Button btnNextDate;
    private EditText etStartDate, etEndDate, etStartTime, etEndTime;
    private String eventTitle;
    private String eventDesc;
    private FragmentCommunication fragmentCommunication;


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        communication = (FragmentCommunication) context;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            eventTitle = getArguments().getString("title");
            eventDesc = getArguments().getString("description");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_time_and_date, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews(view);
    }

    private void initViews(View view) {
        btnNextDate = view.findViewById(R.id.btnNextDate);
        etStartDate = view.findViewById(R.id.etStartDate);
        etEndDate = view.findViewById(R.id.etEndDate);
        etStartTime = view.findViewById(R.id.etStartTime);
        etEndTime = view.findViewById(R.id.etEndTime);

        btnNextDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();

                String startDate = etStartDate.getText().toString();
                String endDate = etEndDate.getText().toString();
                String startTime = etStartTime.getText().toString();
                String endTime = etEndTime.getText().toString();
                eventTitle = getArguments().getString("title");
                eventDesc = getArguments().getString("description");
                bundle.putString("eventTitle", eventTitle);
                bundle.putString("eventDesc", eventDesc);
                bundle.putString("startDate", startDate);
                bundle.putString("endDate", endDate);
                bundle.putString("startTime", startTime);
                bundle.putString("endTime", endTime);

//                Toast.makeText(getContext(), "Data:" + eventTitle + "Desc " + eventDesc, Toast.LENGTH_SHORT).show();
                if (communication != null) {
                    communication.launchThirdFrag(bundle);
                }
            }
        });

    }
}