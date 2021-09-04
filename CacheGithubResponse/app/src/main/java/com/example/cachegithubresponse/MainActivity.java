package com.example.cachegithubresponse;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cachegithubresponse.Adapter.GithubAdapter;
import com.example.cachegithubresponse.ApiService.ApiService;
import com.example.cachegithubresponse.ApiService.Network;
import com.example.cachegithubresponse.Model.ResponseModel;

import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private EditText etGitUserName;
    private Button btnFetchData;
    private GithubAdapter githubAdapter;
    private List<ResponseModel> responseModelList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        recyclerView = findViewById(R.id.recyclerView);
        etGitUserName = findViewById(R.id.etGitUserName);
        btnFetchData = findViewById(R.id.btnFetchData);
        btnFetchData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callApiService();
                setRecyclerView();
            }
        });
    }

    private void callApiService() {

        ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Please wait a moment..");
        progressDialog.show();

        ApiService apiService = Network.getInstance().create(ApiService.class);
        String query = etGitUserName.getText().toString();
        apiService.getData(query).enqueue(new Callback<List<ResponseModel>>() {
            @Override
            public void onResponse(Call<List<ResponseModel>> call, Response<List<ResponseModel>> response) {
                progressDialog.dismiss();
                if (response.code() == HttpURLConnection.HTTP_OK) {
                    List<ResponseModel> responseModelArrayList = response.body();
                    responseModelList.addAll(responseModelArrayList);
                    githubAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<List<ResponseModel>> call, Throwable t) {
                progressDialog.dismiss();
            }
        });
    }

    private void setRecyclerView() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        githubAdapter = new GithubAdapter(responseModelList);
        recyclerView.setAdapter(githubAdapter);
        recyclerView.setLayoutManager(layoutManager);
    }
}