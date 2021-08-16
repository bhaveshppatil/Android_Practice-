package com.example.inshortsnewsapp;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiClient {
    @GET("news")
    Call<ResponseModel> getContent(
            @Query("category") String category);
}

interface ClickListener {
    void onItemClick(DataModel dataModel);
}
