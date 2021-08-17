package com.example.retrofit1_we;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private EditText tvUserID;
    private Button btnCallApi;
    private TextView tvFirstName;
    private TextView tvLastName;
    private TextView tvEmail;
    private ImageView tvAvatar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        tvUserID = findViewById(R.id.etUserId);
        btnCallApi = findViewById(R.id.btnCallApi);
        tvFirstName = findViewById(R.id.tvfirstName);
        tvLastName = findViewById(R.id.tvLastName);
        tvEmail = findViewById(R.id.tvEmail);
        tvAvatar = findViewById(R.id.ivAvatar);
        btnCallApi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ApiService apiService = Network.getInstance().create(ApiService.class);
                int userID = Integer.parseInt(tvUserID.getText().toString());
                apiService.getUser(userID).enqueue(new Callback<ResponseModel>() {
                    @Override
                    public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                        ResponseModel model = response.body();
                        String firstName = model.getData().getFirstName();
                        String lastName = model.getData().getLastName();
                        String email = model.getData().getEmail();
                        tvFirstName.setText(firstName);
                        tvLastName.setText(lastName);
                        tvEmail.setText(email);
                        Glide.with(tvAvatar).load(model.getData().getAvatar()).into(tvAvatar);
                    }

                    @Override
                    public void onFailure(Call<ResponseModel> call, Throwable t) {

                    }
                });
            }
        });
    }
}