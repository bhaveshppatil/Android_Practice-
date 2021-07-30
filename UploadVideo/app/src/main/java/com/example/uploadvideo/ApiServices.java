package com.example.uploadvideo;

import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface ApiServices {
    @Headers("Authorization: Client-ID d378239471717a5")
    @POST("3/upload")
    @Multipart
    Call<ResponseDTO> uploadVideo(
            @Part MultipartBody.Part file,
            @Part("title") String title
    );
}
