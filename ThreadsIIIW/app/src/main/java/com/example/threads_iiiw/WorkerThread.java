package com.example.threads_iiiw;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;

public class WorkerThread extends HandlerThread {

    private Handler handler;
    private Handler mainHandler;

    public WorkerThread(String name, Handler mainHandler) {
        super(name);
        this.mainHandler = mainHandler;
    }

    @Override
    protected void onLooperPrepared() {
        super.onLooperPrepared();
        int progress = 0;

        for (int i = 0; i < 11; i++) {
            try {
                Thread.sleep(2000);
                progress = progress + 10;
                Message message = Message.obtain();
                message.obj = progress;

                message.what = 1;
                if (i == 9) {
                    message.what = 2;
                    message.obj = "Task Completed";
                }
                mainHandler.sendMessage(message);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
