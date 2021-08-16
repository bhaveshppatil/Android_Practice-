package com.example.sendbroadcastwithsecurityconsiderations;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
    private TextView tvData;
    private ReceiveBroadcast receiveBroadcast;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        tvData = findViewById(R.id.tvData);
        String receivedData = getIntent().getStringExtra("receivedData");
        tvData.setText(receivedData);
        Toast.makeText(this, "Broadcast data receive successfully with security considerations", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(receiveBroadcast);
    }
}