package com.example.getuserdetails_kotlin

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("api/users/{ID}")
    fun getID(@Path("ID") id: Int): Call<ResponseModel>
}