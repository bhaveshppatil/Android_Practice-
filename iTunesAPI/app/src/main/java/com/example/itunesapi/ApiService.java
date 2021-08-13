package com.example.itunesapi;

import com.example.itunesapi.Model.ResponseModel;
import com.example.itunesapi.Model.ResultsModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {

    @GET("search")
    Call<ResponseModel> getQuery(@Query("term") String term);
}
