package com.example.taskmanagement;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class Login extends AppCompatActivity {

    CardView crdLogin;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    EditText etLoginEmail, etLoginPasswd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        crdLogin = findViewById(R.id.crdLogin);
        etLoginEmail = findViewById(R.id.etLoginEmail);
        etLoginPasswd = findViewById(R.id.etLoginPasswd);

        crdLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = etLoginEmail.getText().toString();
                String passwd = etLoginPasswd.getText().toString();

                if (email.matches(emailPattern) && passwd.length() >= 6) {
                    Intent intent = new Intent(Login.this, Welcome.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(Login.this, "Invalid Information Entered, Please Check once..", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}