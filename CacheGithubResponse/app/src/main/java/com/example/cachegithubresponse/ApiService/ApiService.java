package com.example.cachegithubresponse.ApiService;

import com.example.cachegithubresponse.Model.ResponseModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiService {
    @GET("/users/{user}/repos")
    Call<List<ResponseModel>> getData(@Path("user") String user);
}
