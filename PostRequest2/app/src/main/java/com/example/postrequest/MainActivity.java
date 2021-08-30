package com.example.postrequest;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.net.HttpURLConnection;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private EditText etRequestType, etEmail, etPasswd, etTitle;
    private Button btnPost;
    private UserData userData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etEmail = findViewById(R.id.etEmail);
        etRequestType = findViewById(R.id.etRequestType);
        etPasswd = findViewById(R.id.etPasswd);
        etTitle = findViewById(R.id.etTitle);
        btnPost = findViewById(R.id.btnPost);

        btnPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = etEmail.getText().toString();
                String request = etRequestType.getText().toString();
                String title = etTitle.getText().toString();
                userData = new UserData(title, email, request);
                callApi();
            }
        });
    }

    private void callApi() {
        ApiService apiService = Network.getInstance().create(ApiService.class);
        ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Please wait a moment");
        progressDialog.show();

        apiService.postData(userData).enqueue(new Callback<ResponseModel>() {
            @Override
            public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                progressDialog.dismiss();
                if (response.code() == HttpURLConnection.HTTP_CREATED && response.body() != null) {

                    Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                    intent.putExtra("title", response.body().getTitle());
                    intent.putExtra("id", response.body().getId());
                    intent.putExtra("email", response.body().getEmail());
                    intent.putExtra("request", response.body().getRequestType());
                    startActivity(intent);
                }
            }

            @Override
            public void onFailure(Call<ResponseModel> call, Throwable t) {
                progressDialog.dismiss();
            }
        });
    }
}