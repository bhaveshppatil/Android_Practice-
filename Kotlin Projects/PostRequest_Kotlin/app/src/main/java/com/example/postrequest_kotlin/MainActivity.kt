package com.example.postrequest_kotlin

import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {
    private lateinit var userData: UserData
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnPost.setOnClickListener {
            val email: String = etEmail.text.toString();
            val title: String = etTitle.text.toString();
            val request: String = etRequestType.text.toString();
            userData = UserData(email, title, request);
            callApiService()

        }
    }

    private fun callApiService() {

        val progressDialog = ProgressDialog(this)
        progressDialog.setMessage("Please Wait")
        progressDialog.show()

        val apiServices = Network.getInstance().create(ApiServices::class.java)

        apiServices.postData(userData)?.enqueue(object : Callback<ResponseModel?> {
            override fun onResponse(
                call: Call<ResponseModel?>,
                response: Response<ResponseModel?>
            ) {
                progressDialog.dismiss()

                val intent = Intent(this@MainActivity, SecondActivity::class.java)

                intent.putExtra("title", response.body()?.title)
                intent.putExtra("id", response.body()?.id)
                intent.putExtra("email", response.body()?.email)
                intent.putExtra("request", response.body()?.requestType)
                startActivity(intent)

            }

            override fun onFailure(call: Call<ResponseModel?>, t: Throwable) {
                progressDialog.dismiss();
            }
        })
    }
}