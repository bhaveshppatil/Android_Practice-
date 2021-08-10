package com.example.threadsyou;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private Button btnCreate;
    private ProgressBar progressIndicator;
    private Handler handler = new Handler();
    private TextView tvProgress;


    private Runnable task = new Runnable() {
        @Override
        public void run() {
            for (int i = 0; i < 11; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                int finalI = i;
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        progressIndicator.setProgress(finalI);
                        if (finalI == 10) {
                            btnCreate.setText("Task Completed");
                            tvProgress.setText(finalI + "%");
                        } else {
                            tvProgress.setText(finalI + "%");
                        }
                    }
                });
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCreate = findViewById(R.id.btnCreate);
        tvProgress = findViewById(R.id.txtProgress);
        progressIndicator = findViewById(R.id.progressBar);
        WorkerThread workerThread = new WorkerThread();
        workerThread.start();

        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                workerThread.addTaskToQueue(task);
            }
        });

    }
}