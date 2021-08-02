package com.example.dynamicfragments;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

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

public class DynamicFragment extends Fragment {

    private List<ResponseModel> responseModelList = new ArrayList<>();
    private RecyclerView recyclerView;
    private DataAdapter dataAdapter;
    private Button btnFetch;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dynamic, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews(view);
    }

    private void initViews(View view) {
        btnFetch = view.findViewById(R.id.btnFetch);
        recyclerView = view.findViewById(R.id.recyclerView);

        btnFetch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setRecyclerView();
                apiClient();
            }
        });
    }

    private void apiClient() {
        ProgressDialog progressDialog = new ProgressDialog(getContext());
        progressDialog.setMessage("Please wait...");
        progressDialog.show();

        ApiService apiService = Network.getInstance().create(ApiService.class);
        apiService.getData("shivarajp", "2cbe00030c04472c9d8ad4b0ec112dbe",
                "raw", "c651391e428182f08d60d59e79073f3fcf79b858", "nobroker").enqueue(new Callback<List<ResponseModel>>() {
            @Override
            public void onResponse(Call<List<ResponseModel>> call, Response<List<ResponseModel>> response) {
                progressDialog.dismiss();
                btnFetch.setText("Data Fetch Successfully");
                if (response.code() == HttpURLConnection.HTTP_OK) {
                    responseModelList = response.body();
                    dataAdapter.updateData(responseModelList);
                }
            }

            @Override
            public void onFailure(Call<List<ResponseModel>> call, Throwable t) {
                progressDialog.dismiss();

            }
        });
    }

    private void setRecyclerView() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        dataAdapter = new DataAdapter(responseModelList);
        recyclerView.setAdapter(dataAdapter);
        recyclerView.setLayoutManager(layoutManager);
    }
}