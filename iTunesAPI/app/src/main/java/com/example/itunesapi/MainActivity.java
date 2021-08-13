package com.example.itunesapi;

import android.app.ProgressDialog;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.SearchView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.itunesapi.Model.ResponseModel;
import com.example.itunesapi.Model.ResultsModel;

import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements ClickListener {

    private RecyclerView recyclerView;
    private SearchView searchView;
    private String term;
    private MediaPlayer mediaPlayer;
    private itunesDataHolder itunesDataHolder;
    private ResponseModel responseModel;
    private ItunesDataAdapter dataAdapter;
    private List<ResultsModel> resultsModelList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        setRecyclerView();
    }

    private void initViews() {
        recyclerView = findViewById(R.id.recyclerView);
        searchView = findViewById(R.id.srcView);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                term = searchView.getQuery().toString();
                apiService();
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
    }

    private void apiService() {

        ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Please wait a moment...");
        progressDialog.show();

        ApiService apiService = Network.getInstance().create(ApiService.class);
        apiService.getQuery(term).enqueue(new Callback<ResponseModel>() {
            @Override
            public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                if (response.code() == HttpURLConnection.HTTP_OK) {
                    responseModel = response.body();
                    resultsModelList.addAll(responseModel.getResults());
                    dataAdapter.notifyDataSetChanged();

                }
            }

            @Override
            public void onFailure(Call<ResponseModel> call, Throwable t) {


            }
        });

    }

    private void setRecyclerView() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        dataAdapter = new ItunesDataAdapter(resultsModelList, this);
        recyclerView.setAdapter(dataAdapter);
        recyclerView.setLayoutManager(layoutManager);
    }

    @Override
    public void onItemClick(ResultsModel resultsModel, int position) {

    }

    @Override
    public void remove(ResultsModel resultsModel) {
        resultsModelList.remove(resultsModel);
        dataAdapter.notifyDataSetChanged();

    }
}