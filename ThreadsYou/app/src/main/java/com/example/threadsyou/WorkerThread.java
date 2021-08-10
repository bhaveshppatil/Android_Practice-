package com.example.threadsyou;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;

public class WorkerThread extends Thread {
    private Handler handler;

    @Override
    public void run() {
        super.run();
        Looper.prepare();
        handler = new Handler(Looper.myLooper());
        Looper.loop();
    }
    public void addTaskToQueue(Runnable runnable){
        if (handler != null){
            handler.post(runnable);
        }
    }
}
