package com.example.rememberme;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private static final String FILE_NAME = "myFile";
    private EditText etName, etPassword;
    private CheckBox checkBox;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.etName);
        etPassword = findViewById(R.id.etPassword);
        checkBox = (CheckBox) findViewById(R.id.RemCheckbox);
        btnLogin = findViewById(R.id.btnLogin);

        SharedPreferences sharedPreferences = getSharedPreferences(FILE_NAME, MODE_PRIVATE);
        String name = sharedPreferences.getString("name", "");
        String passwd = sharedPreferences.getString("passwd", "");

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkBox.isChecked()) {
                    Intent intent = new Intent(MainActivity.this, UserData.class);
                    String name = etName.getText().toString();
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("name", name);
                    editor.apply();
                    startActivity(intent);
                } else {
                    Toast.makeText(MainActivity.this, "please check the box", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
            

    private void StoreData(String name) {
        SharedPreferences.Editor editor = getSharedPreferences(FILE_NAME, MODE_PRIVATE).edit();
        editor.putString("name", name);
        editor.apply();
    }
}