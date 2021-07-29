package com.example.receivenameandage;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

public class MainActivity extends AppCompatActivity {
    private TextView tvName, tvAge;
    private Button btnSend;
    private LocalBroadcastManager localBroadcastManager;
    private Receiver receiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvName = findViewById(R.id.tvName);
        tvAge = findViewById(R.id.tvAge);
        btnSend = findViewById(R.id.btnSend);
        localBroadcastManager = LocalBroadcastManager.getInstance(this);
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.dev.receiver");
                intent.putExtra("name", "Bhavesh Patil");
                intent.putExtra("age", 22);
                localBroadcastManager.sendBroadcast(intent);
            }
        });
        registerLocalReceiver();
    }

    private void registerLocalReceiver() {
        receiver = new Receiver();
        IntentFilter intentFilter = new IntentFilter("com.dev.receiver");
        localBroadcastManager.registerReceiver(receiver,intentFilter);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        localBroadcastManager.unregisterReceiver(receiver);
    }

    private class Receiver extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {
            if (intent != null){
                String name = intent.getStringExtra("name");
                int age = intent.getIntExtra("age", 0);
                tvName.setText("Name: "+name);
                tvAge.setText("Age: "+age);
                btnSend.setText("Data received");
                Toast.makeText(context, "Data received Successfully", Toast.LENGTH_SHORT).show();
            }else {
                Toast.makeText(context, "Data receive Failed", Toast.LENGTH_SHORT).show();
            }
        }
    }
}