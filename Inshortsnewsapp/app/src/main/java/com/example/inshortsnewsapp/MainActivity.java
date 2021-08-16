package com.example.inshortsnewsapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements ClickListener {

    ClickListener clickListener;
    private List<DataModel> dataModelList = new ArrayList<>();
    private EditText etCategory;
    private Button btnFetch;
    private NewsAdapter newsAdapter;
    private ResponseModel responseModel;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        setRecyclerView();
    }

    private void initViews() {
        etCategory = findViewById(R.id.etCategory);
        btnFetch = findViewById(R.id.btnFetch);
        recyclerView = findViewById(R.id.recyclerView);
        btnFetch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                apiService();
            }
        });
    }

    private void apiService() {

        ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Please wait a moment");
        progressDialog.show();
        ApiClient apiClient = Network.getInstance().create(ApiClient.class);
        String category = etCategory.getText().toString();

        apiClient.getContent(category).enqueue(new Callback<ResponseModel>() {
            @Override
            public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                if (response.code() == HttpURLConnection.HTTP_OK) {
                    responseModel = response.body();
                    dataModelList.addAll(responseModel.getData());
                    newsAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<ResponseModel> call, Throwable t) {
                progressDialog.dismiss();
            }
        });

    }

    private void setRecyclerView() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        newsAdapter = new NewsAdapter(dataModelList, this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(newsAdapter);

    }

    @Override
    public void onItemClick(DataModel dataModel) {
        String Url = dataModel.getReadMoreUrl();
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(Url));
        startActivity(intent);
    }
}