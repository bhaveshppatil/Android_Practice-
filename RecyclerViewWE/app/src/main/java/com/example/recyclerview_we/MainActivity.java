package com.example.recyclerview_we;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<Student> studentsList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        buildStudentList();
        setRecyclerView();
    }

    private void buildStudentList() {
        studentsList = new ArrayList<>();
        Student student = new Student("Bhavesh", "AND_09", 22);
        studentsList.add(student);
        Student student1 = new Student("Nap", "AND_08", 23);
        studentsList.add(student1);

        for (int i = 0; i < 13; i++) {
            Student student2 = new Student("Sam" +"-" + i, "AND_010", 24);
            studentsList.add(student2);
        }
    }

    private void setRecyclerView(){
        StudentAdapter studentAdapter = new StudentAdapter(studentsList);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(studentAdapter);
    }

    private void initView() {
        recyclerView = findViewById(R.id.recyclerView);
    }
}