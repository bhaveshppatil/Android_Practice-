package com.example.taskmanagement;

import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class createNewTask extends AppCompatActivity {

    private CardView crdAddTask;
    private RadioButton taskCompleted, taskPending;
    private RelativeLayout relativeLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_new_task);

        taskCompleted = findViewById(R.id.taskCompleted);
        taskPending = findViewById(R.id.taskPending);
        relativeLayout = findViewById(R.id.deleteTaskLY);

        taskCompleted.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                relativeLayout.setVisibility(View.VISIBLE);

            }
        });


        relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(createNewTask.this, "Task Deleted Successfully", Toast.LENGTH_SHORT).show();
            }
        });

        crdAddTask = findViewById(R.id.crdAddTask);
        crdAddTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(createNewTask.this, "Task Added Successfully", Toast.LENGTH_SHORT).show();
            }
        });
    }
}