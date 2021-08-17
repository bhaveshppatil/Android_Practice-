package com.example.permission;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

public class MainActivity extends AppCompatActivity {

    private static final int REQ_CODE = 99;
    private static final int REQ = 01;
    private Button btnPermission;
    private int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnPermission = findViewById(R.id.btnPermission);

        btnPermission.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] permission = {Manifest.permission.CAMERA};
                ActivityCompat.requestPermissions(MainActivity.this, permission, REQ_CODE);

            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            toastMessage("Camera Permission Granted");
        } else if (grantResults[0] == PackageManager.PERMISSION_DENIED) {
            if (count < 1) {
                String[] permission = {Manifest.permission.CAMERA};
                ActivityCompat.requestPermissions(MainActivity.this, permission, REQ);
                count++;
            }
        }  if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            toastMessage("Permission Granted");
        } else if (grantResults[0] == PackageManager.PERMISSION_DENIED) {
            toastMessage("Permission Denied");
        }
    }

    private void toastMessage(String Message) {
        Toast.makeText(this, Message, Toast.LENGTH_SHORT).show();
    }
}