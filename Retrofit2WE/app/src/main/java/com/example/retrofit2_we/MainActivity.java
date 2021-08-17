package com.example.retrofit2_we;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
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
    private TextView tvName, tvEmail, tvBody;
    private Button btnFetch;
    private RecyclerView recyclerView;
    private EditText etPostId;
    private CardView cardView;
    private List<ResponseModel> responseModelList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvName = findViewById(R.id.tvName);
        tvEmail = findViewById(R.id.tvEmail);
        tvBody = findViewById(R.id.tvBody);
        etPostId = findViewById(R.id.etPostId);
        recyclerView = findViewById(R.id.recyclerView);
        btnFetch = findViewById(R.id.btnFetch);
        btnFetch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callApiService();
            }
        });
        setRecyclerView();

    }

    private void callApiService() {
        ApiService apiService = Network.getInstance().create(ApiService.class);
        int postID = Integer.parseInt(etPostId.getText().toString());
        ProgressDialog progressBar = new ProgressDialog(this);
        progressBar.setMessage("Please Wait");
        progressBar.show();

        apiService.getPost(postID).enqueue(new Callback<List<ResponseModel>>() {
            @Override
            public void onResponse(Call<List<ResponseModel>> call, Response<List<ResponseModel>> response) {
                progressBar.dismiss();
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

    private void setRecyclerView() {
        DataAdapter dataAdapter = new DataAdapter(responseModelList);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setAdapter(dataAdapter);
        recyclerView.setLayoutManager(layoutManager);
    }

}