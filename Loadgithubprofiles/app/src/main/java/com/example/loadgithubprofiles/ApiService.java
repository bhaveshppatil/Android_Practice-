package com.example.loadgithubprofiles;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiService {

    @GET("/users/{user}/repos")
    Call<List<ResponseModel>> getSearchQuery(
            @Path("user") String user
    );
}
