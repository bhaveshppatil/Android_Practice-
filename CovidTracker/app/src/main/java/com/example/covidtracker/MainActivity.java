package com.example.covidtracker;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    private EditText etEmail, etPassword;
    private Button btnLogin;
    private List<ResponseModel> responseModelList = new ArrayList<>();
    private CheckBox checkBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnLogin = findViewById(R.id.btnLogin);
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        checkBox = findViewById(R.id.checkboxx);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isValidEmail = isValidEmail();
                boolean isPasswdValid = isValidPassword();
                if (isValidEmail && isPasswdValid) {
                    isBoxChecked();
                    PreferenceHelper.writeStringToPreference(MainActivity.this, "Email", etEmail.getText().toString());
                    PreferenceHelper.writeStringToPreference(MainActivity.this, "Password", etPassword.getText().toString());
                }
            }
        });
    }

    private boolean isValidEmail() {
        String email = etEmail.getText().toString();
        if (email.matches(emailPattern)) {
            return true;
        } else {
            etEmail.setError("InValid Email");
            return false;
        }
    }

    private boolean isValidPassword() {
        String passwd = etPassword.getText().toString();
        if (passwd.length() >= 6) {
            return true;
        } else {
            etPassword.setError("Password is Very Short");
            return false;
        }
    }

    private void isBoxChecked() {
        if (checkBox.isChecked()) {
            Intent intent = new Intent(MainActivity.this, HomeScreen.class);
            startActivity(intent);
        } else {
            Intent intent = new Intent(MainActivity.this, MainActivity.class);
            startActivity(intent);
        }
    }
}