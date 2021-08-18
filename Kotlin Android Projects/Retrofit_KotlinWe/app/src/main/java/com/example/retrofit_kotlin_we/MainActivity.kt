package com.example.retrofit_kotlin_we

import android.app.ProgressDialog
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.internal.immutableListOf
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    var responseModelList = immutableListOf<ResponseModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnFetch.setOnClickListener { callApiService() }
    }

    private fun callApiService() {
        val apiService: ApiService = Network.getInstance().create(ApiService::class.java)
        val postID: Int = etPostId.text.toString().toInt()

        val progressBar = ProgressDialog(this)
        progressBar.setMessage("Please Wait")
        progressBar.show()
        apiService.getPosts(postID).enqueue(object : Callback<List<ResponseModel>> {
            override fun onResponse(
                call: Call<List<ResponseModel>>,
                response: Response<List<ResponseModel>>
            ) {
                responseModelList = response.body()!!
                setRecyclerView()
            }

            override fun onFailure(call: Call<List<ResponseModel>>, t: Throwable) {

            }
        })

    }

    private fun setRecyclerView() {
        val dataAdapter = DataAdapter(responseModelList)
        val layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = dataAdapter
        recyclerView.layoutManager = layoutManager
    }
}
