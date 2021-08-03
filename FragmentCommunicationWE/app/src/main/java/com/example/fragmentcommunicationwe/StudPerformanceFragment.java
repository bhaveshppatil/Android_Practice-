package com.example.fragmentcommunicationwe;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class StudPerformanceFragment extends Fragment {

    private EditText etGrade, etPercentage;
    private Button btnPreview;
    private String name;
    private int age;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null){
            name = getArguments().getString("name");
            age = getArguments().getInt("age");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_stud_performance, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews(view);
    }

    private void initViews(View view) {
        etGrade = view.findViewById(R.id.etGrade);
        etPercentage = view.findViewById(R.id.etPercentage);
        btnPreview = view.findViewById(R.id.btnPreview);
        btnPreview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String grade = etGrade.getText().toString();
                String percentage = etPercentage.getText().toString();
                StudentModel studentModel = new StudentModel(name, age, percentage, grade);
                Intent intent = new Intent(getActivity(), PreviewActivity.class);
                intent.putExtra("studentModel", studentModel);
                startActivity(intent);
            }
        });
    }
}