package com.example.fragmentcommunicationwe;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class PreviewActivity extends AppCompatActivity {
    private TextView tvName, tvPercentage, tvGrade, tvAge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preview);
        tvName = findViewById(R.id.tvStudentName);
        tvAge = findViewById(R.id.tvStudentAge);
        tvGrade = findViewById(R.id.tvStudentGrade);
        tvPercentage = findViewById(R.id.tvStudentPercentage);
        getData();
    }

    private void getData() {
        StudentModel studentModel = (StudentModel) getIntent().getSerializableExtra("studentModel");
        tvName.setText("Student Name: " + studentModel.getName());
        tvAge.setText("Student Age: " + studentModel.getAge());
        tvGrade.setText("Student Grade: " + studentModel.getGrade());
        tvPercentage.setText("Student Percentage: " + studentModel.getPercentage());
    }
}