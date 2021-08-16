package com.example.sendbroadcastwithsecurityconsiderations;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class ReceiveBroadcast extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        String data = intent.getStringExtra("data");
        Intent intent1 = new Intent(context, SecondActivity.class);
        intent1.putExtra("receivedData", data);
        context.startActivity(intent1);
    }
}
