package com.example.kotlinscopingfunctionsiw

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("api/users/{ID}")
    fun getData(@Path("ID") id: Int): Call<ResponseModel>

}