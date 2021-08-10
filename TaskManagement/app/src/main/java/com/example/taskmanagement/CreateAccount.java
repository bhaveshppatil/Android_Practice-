package com.example.taskmanagement;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class CreateAccount extends AppCompatActivity {
    private EditText etEmail, etPasswd, etReEnterPasswd;
    private CardView cardRegister;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        etEmail = findViewById(R.id.etEmail);
        etPasswd = findViewById(R.id.etPassword);
        etReEnterPasswd = findViewById(R.id.etConfirm);
        cardRegister = findViewById(R.id.crdRegister);

        cardRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String passwd = etPasswd.getText().toString();
                String confirmPasswd = etReEnterPasswd.getText().toString();
                String email = etEmail.getText().toString();

                if (passwd.matches(confirmPasswd) && passwd.length() >= 6 && email.matches(emailPattern) ){
                    Intent intent = new Intent(CreateAccount.this, Welcome.class);
                    startActivity(intent);
                }else {
                    Toast.makeText(CreateAccount.this, "Invalid Information Entered, Please Check once..", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}