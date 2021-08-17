package com.example.camerapermission;

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
    private static final int REQUEST = 99;
    private Button btnCamReq;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnCamReq = findViewById(R.id.btnCamReq);
        btnCamReq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] camPerms = {Manifest.permission.CAMERA};
                ActivityCompat.requestPermissions(MainActivity.this, camPerms, REQUEST);
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(this, "Camera Permission Granted", Toast.LENGTH_SHORT).show();
        } else if (grantResults[0] == PackageManager.PERMISSION_DENIED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(MainActivity.this, permissions[0])) {
                Toast.makeText(this, "Permission Denied", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Permission denied by clicking Don't show again ,\n" + "please go to settings and enable the permission", Toast.LENGTH_LONG).show();
            }
        }
    }
}