package com.example.getresourcesapi;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiServices {

    @GET("/api/unknown/{postID}")
    Call<ResponseModel> getData(@Path("postID") int postID);

}
