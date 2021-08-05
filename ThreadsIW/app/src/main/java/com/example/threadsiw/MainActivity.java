package com.example.threadsiw;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Button btnFirst, btnSecond;
    private Runnable taskFirst = new Runnable() {
        @Override
        public void run() {
            Log.d("thread", "Task First "+Thread.currentThread().getName());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    };
    private Runnable taskSecond = new Runnable() {
        @Override
        public void run() {
            Log.d("thread","Task Second "+ Thread.currentThread().getName());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnFirst = findViewById(R.id.btnFirst);
        btnSecond = findViewById(R.id.btnSecond);
        WorkerThread workerThread = new WorkerThread();
        workerThread.start();

        btnFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                workerThread.addTaskInQueue(taskFirst);
            }
        });

        btnSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                workerThread.addTaskInQueue(taskSecond);
            }
        });
    }
}