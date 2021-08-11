package com.example.getresourcesapi;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SecondActivity extends AppCompatActivity {

    int num = 0;
    private TextView tvName, tvYear, tvComapany;
    private LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Intent intent = getIntent();
        num = intent.getIntExtra("number", 0);
        initViews();
        apiService();
    }

    private void initViews() {
        tvName = findViewById(R.id.tvName);
        tvYear = findViewById(R.id.tvYear);
        tvComapany = findViewById(R.id.tvCaption);
        linearLayout = findViewById(R.id.linearLayout);
    }

    private void apiService() {
        ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Please wait a moment");
        progressDialog.show();
        ApiServices apiServices = Network.getInstance().create(ApiServices.class);
        apiServices.getData(num).enqueue(new Callback<ResponseModel>() {
            @Override
            public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                progressDialog.dismiss();
                if (response.body() != null) {
                    ResponseModel responseModel = response.body();

                    tvName.setText(responseModel.getData().getName());
                    int year = responseModel.getData().getYear();
                    tvYear.setText(String.valueOf(year));
                    tvComapany.setText(responseModel.getSupport().getText());
                    String color = responseModel.getData().getColor();
                    tvName.setTextColor(Color.parseColor(color));
                    tvYear.setTextColor(Color.parseColor(color));
                    tvComapany.setTextColor(Color.parseColor(color));
                    linearLayout.setBackgroundColor(Color.parseColor(color));
                }
            }

            @Override
            public void onFailure(Call<ResponseModel> call, Throwable t) {
                progressDialog.dismiss();

            }
        });
    }
}