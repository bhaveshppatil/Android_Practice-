package com.example.threads_iiiw;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.progressindicator.CircularProgressIndicator;

public class MainActivity extends AppCompatActivity {

    private CircularProgressIndicator progressIndicator;
    private Handler mainThreadHandler = new Handler(Looper.getMainLooper()) {

        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);

            switch (msg.what) {
                case 1:
                    int progress = (int) msg.obj;
                    progressIndicator.setProgress(progress);
                    progressIndicator.setIndicatorSize(200);
                    progressIndicator.setTrackThickness(30);
                    break;
                case 2:
                    String message = (String) msg.obj;
                    Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressIndicator = findViewById(R.id.progressIndicator);
        WorkerThread workerThread = new WorkerThread("async", mainThreadHandler);
        workerThread.start();

    }
}