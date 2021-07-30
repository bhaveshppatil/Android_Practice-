package com.example.loadgithubprofiles;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class githubFragment extends Fragment {

    private EditText etQueryUsername;
    private Button btnFetchData;
    private RecyclerView recyclerView;
    private GithubAdapter githubAdapter;
    private List<ResponseModel> responseModelList = new ArrayList<>();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_github, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);

    }

    private void initView(View view) {
        recyclerView = view.findViewById(R.id.recyclerView);
        etQueryUsername = view.findViewById(R.id.etQueryUsername);
        btnFetchData = view.findViewById(R.id.btnFetchData);
        btnFetchData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setRecyclerView();
                apiResponse();
            }
        });
    }

    private void apiResponse() {
        ProgressDialog progressDialog = new ProgressDialog(getContext());
        progressDialog.setMessage("Please wait...");
        progressDialog.show();
        ApiService apiService = NetWork.getInstance().create(ApiService.class);
        String username = etQueryUsername.getText().toString();
        apiService.getSearchQuery(username).enqueue(new Callback<List<ResponseModel>>() {
            @Override
            public void onResponse(Call<List<ResponseModel>> call, Response<List<ResponseModel>> response) {
                progressDialog.dismiss();
                if (response.code() == HttpURLConnection.HTTP_OK) {
                    responseModelList = response.body();
                    githubAdapter.updateData(responseModelList);
                }
            }

            @Override
            public void onFailure(Call<List<ResponseModel>> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(getContext(), "Failed", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void setRecyclerView() {
        githubAdapter = new GithubAdapter(responseModelList);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setAdapter(githubAdapter);
        recyclerView.setLayoutManager(layoutManager);
    }
}