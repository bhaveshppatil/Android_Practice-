package com.example.boundservice;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;

public class MusicService extends Service {

    private MediaPlayer mediaPlayer;

    public MusicService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return new ServiceBinder();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mediaPlayer = MediaPlayer.create(this, R.raw.onmyway);
    }

    public void playTrack() {
        mediaPlayer.start();

    }

    public void pauseTrack() {
        mediaPlayer.pause();

    }

    public void stopTrack() {
        mediaPlayer.stop();

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        stopTrack();
    }

    public class ServiceBinder extends Binder {
        public MusicService getMusicService() {
            return MusicService.this;
        }
    }
}