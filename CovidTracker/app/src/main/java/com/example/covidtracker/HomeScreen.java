package com.example.covidtracker;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
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

public class HomeScreen extends AppCompatActivity implements ClickListener {
    private TextView date, positive, negative, hospitalizedCurrently, onVentilatorCurrently, death, dateChecked;
    private CardView cardView;
    private RecyclerView recyclerView;
    private ClickListener clickListener;
    private ResponseModel responseModel;
    private CovidAdapter covidAdapter;
    private List<ResponseModel> responseModelList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        initViews();
        apiClient();
        setRecyclerView();
    }

    private void initViews() {
        date = findViewById(R.id.date);
        positive = findViewById(R.id.positive);
        negative = findViewById(R.id.negative);
        hospitalizedCurrently = findViewById(R.id.hospitalizedCurrently);
        onVentilatorCurrently = findViewById(R.id.onVentilatorCurrently);
        death = findViewById(R.id.death);
        dateChecked = findViewById(R.id.dateChecked);
        cardView = findViewById(R.id.crdView);
        recyclerView = findViewById(R.id.recyclerView);
    }

    public void setRecyclerView() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        CovidAdapter covidAdapter = new CovidAdapter(responseModelList, clickListener);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(covidAdapter);
    }

    private void apiClient() {

        ProgressDialog dialog = new ProgressDialog(this);
        dialog.setMessage("Please Wait for few second");
        dialog.show();

        ApiServices apiServices = Network.getRetrofitInstance().create(ApiServices.class);
        apiServices.getPost().enqueue(new Callback<List<ResponseModel>>() {
            @Override
            public void onResponse(Call<List<ResponseModel>> call, Response<List<ResponseModel>> response) {
                dialog.dismiss();
                if (response.body() != null) {
                    responseModelList = response.body();
                    setRecyclerView();
                }
            }

            @Override
            public void onFailure(Call<List<ResponseModel>> call, Throwable t) {

            }
        });
    }

    @Override
    public void onItemClick(int Position, ResponseModel model) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        String url = "https://www.masaischool.com/";
        intent.setData(Uri.parse(url));
        startActivity(intent);
    }
}