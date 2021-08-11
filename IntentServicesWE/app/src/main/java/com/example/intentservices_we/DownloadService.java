package com.example.intentservices_we;

import android.app.IntentService;
import android.content.Intent;

import androidx.annotation.Nullable;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class DownloadService extends IntentService {

    public DownloadService() {
        super("thread");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        downloadFile();
    }


    private void downloadFile() {
        try {
            File createFolder = new File(getFilesDir(), File.separator + "Download");
            if (!createFolder.exists()) {
                createFolder.mkdir();
            }

            File newFile = new File(createFolder,"index.html");
            if (!newFile.exists()) {
                newFile.createNewFile();
            }

            URL url = new URL("https://www.vogella.com/index.html");
            InputStream inputStream = url.openConnection().getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            FileOutputStream fileOutputStream = new FileOutputStream(newFile, true);
            int data = inputStreamReader.read();
            while (data != -1) {
                char ch = (char) data;
                fileOutputStream.write(ch);
                data = inputStreamReader.read();

            }

            FileInputStream inputStream1 = new FileInputStream(newFile);
            int fileData = inputStream1.read();
            StringBuffer stringBuffer = new StringBuffer();
            while (fileData != -1) {
                char ch = (char) fileData;
                stringBuffer = stringBuffer.append(ch);
                fileData = inputStream1.read();
            }

        } catch (Exception e) {

        }
    }

}