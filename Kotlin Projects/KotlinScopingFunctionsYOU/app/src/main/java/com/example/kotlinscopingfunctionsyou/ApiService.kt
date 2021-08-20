package com.example.kotlinscopingfunctionsyou

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("api/users/")
    fun getPost(@Query("page") postId: Int): Call<ResponseModel>

}