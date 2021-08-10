package com.example.services_we;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;

import androidx.core.app.NotificationCompat;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Objects;

public class FileService extends Service {

    private String name = "";

    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            saveDataToFile();
        }
    };

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (intent != null) {
            name = intent.getStringExtra("name");
        }
        launchBackgroundThread();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        showNotificationAndStartForeGround();

    }

    @Override
    public IBinder onBind(Intent intent) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    private void launchBackgroundThread() {
        Thread thread = new Thread(runnable);
        thread.start();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    private void saveDataToFile() {
        try {
            File directory = new File(getFilesDir() + File.separator + "New Folder");
            if (!directory.exists()) {
                directory.mkdir();
            }
            File newFile = new File(directory, "name.txt");
            if (!newFile.exists()) {
                newFile.createNewFile();
            }
            FileOutputStream fileOutputStream = new FileOutputStream(newFile, true);
            OutputStreamWriter streamWriter = new OutputStreamWriter(fileOutputStream);
            streamWriter.append(name + "\n");
            streamWriter.close();

            Intent intent = new Intent("com.android.service");
            intent.putExtra("data", "com.android.service");
            sendBroadcast(intent);

        } catch (IOException e) {

        }
    }

    private void showNotificationAndStartForeGround() {
        createChannel();

        NotificationCompat.Builder notificationBuilder = null;
        notificationBuilder = new NotificationCompat.Builder(this, "CHANNEL_ID")
                .setContentTitle("Incoming Voice Call")
                .setPriority(NotificationCompat.PRIORITY_HIGH);

        Notification notification = null;
        notification = notificationBuilder.build();
        startForeground(120, notification);
    }

    /*
Create noticiation channel if OS version is greater than or eqaul to Oreo
*/
    public void createChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel("CHANNEL_ID", "CHANNEL_NAME", NotificationManager.IMPORTANCE_DEFAULT);
            channel.setDescription("Call Notifications");
            Objects.requireNonNull(this.getSystemService(NotificationManager.class)).createNotificationChannel(channel);
        }
    }
}