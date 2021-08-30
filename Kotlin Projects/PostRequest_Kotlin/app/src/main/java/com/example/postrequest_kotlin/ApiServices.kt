package com.example.postrequest_kotlin

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiServices {

    @POST("posts")
    fun postData(@Body userData: UserData?): Call<ResponseModel?>?
}