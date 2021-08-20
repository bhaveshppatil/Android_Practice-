package com.example.kotlinscopingfunctionsyou

import android.app.ProgressDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_data.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DataFragment : Fragment() {

    private lateinit var dataModelList: List<DataModel>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_data, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        callApiService()
    }

    private fun callApiService() {

        val progressDialog = ProgressDialog(context)
        progressDialog.setMessage("Please Wait")
        progressDialog.show()

        val apiService = Network.getInstance().create(ApiService::class.java)
        apiService.getPost(2).enqueue(object : Callback<ResponseModel> {
            override fun onResponse(call: Call<ResponseModel>, response: Response<ResponseModel>) {
                progressDialog.dismiss()
                response.body()?.run {
                    dataModelList = data as List<DataModel>
                    setRecyclerView()
                }
            }

            override fun onFailure(call: Call<ResponseModel>, t: Throwable) {
                progressDialog.dismiss()
            }
        })

    }

    private fun setRecyclerView() {
        val dataAdapter = DataAdapter(dataModelList)
        val layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = dataAdapter
        recyclerView.layoutManager = layoutManager

    }
}