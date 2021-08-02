package com.example.dynamicfragments;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiService {

    @GET("{gist_user}/{gist_id}/{raw}/{id}/{file_name}")
    Call<List<ResponseModel>> getData(@Path("gist_user") String gist_user,
                                      @Path("gist_id") String gist_id,
                                      @Path("raw") String raw,
                                      @Path("id") String id,
                                      @Path("file_name") String file_name);

}
