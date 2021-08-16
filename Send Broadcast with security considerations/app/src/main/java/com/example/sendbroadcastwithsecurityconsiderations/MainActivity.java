package com.example.sendbroadcastwithsecurityconsiderations;

import android.Manifest;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    public static final String ACTION = "com.android.broadcast";
    private Button btnSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSend = findViewById(R.id.btnSender);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ACTION);
                intent.putExtra("data", "Send Broadcast within the app with security considerations");
                sendBroadcast(intent);
                registerBroadcast();
            }
        });
    }

    private void registerBroadcast() {
        ReceiveBroadcast receiveBroadcast = new ReceiveBroadcast();
        IntentFilter intentFilter = new IntentFilter(ACTION);
        registerReceiver(receiveBroadcast, intentFilter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Intent intent = new Intent(ACTION);
        intent.putExtra("data", "Send Broadcast within the app with security considerations");
        sendBroadcast(intent, Manifest.permission.CAMERA);
    }
}