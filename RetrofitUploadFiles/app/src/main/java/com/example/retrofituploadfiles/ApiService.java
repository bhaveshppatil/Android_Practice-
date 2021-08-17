package com.example.retrofituploadfiles;

import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface ApiService {
    @Headers("Authorization: Client-ID 60ff4267897221a")
    @POST("3/image")
    @Multipart
    Call<ResponseDTO> uploadImage(
            @Part MultipartBody.Part file,
            @Part("title") String title
    );
}
