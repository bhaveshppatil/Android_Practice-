package com.example.retrofit1_we;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiService {
    @GET("/api/users/{userID}")
    Call<ResponseModel> getUser(@Path("userID") int userID);
}
