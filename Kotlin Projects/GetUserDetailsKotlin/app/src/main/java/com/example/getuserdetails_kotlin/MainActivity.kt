package com.example.getuserdetails_kotlin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var responseModel: ResponseModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnFetch.setOnClickListener {
            callApiService()
        }
    }

    private fun callApiService() {
        val apiService = Network.getInstance().create(ApiService::class.java)
        val id = etQueryUsername.text.toString().toInt()
        apiService.getID(id).enqueue(object : Callback<ResponseModel> {
            override fun onResponse(call: Call<ResponseModel>, response: Response<ResponseModel>) {
                response.body()?.run {
                    responseModel = this
                    responseModel.data?.apply {
                        tvEmail.text = responseModel.data!!.email
                        tvCompany.text = data!!.firstName

                    }
                }
            }

            override fun onFailure(call: Call<ResponseModel>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }
}