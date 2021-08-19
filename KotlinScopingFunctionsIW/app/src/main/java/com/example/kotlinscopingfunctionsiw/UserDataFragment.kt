package com.example.kotlinscopingfunctionsiw

import android.app.ProgressDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_user_data.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserDataFragment : Fragment() {

    private lateinit var responseModel: ResponseModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_user_data, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnFetch.setOnClickListener { callApiService() }
    }

    private fun callApiService() {
        val apiService: ApiService = Network.getInstance().create(ApiService::class.java)

        val progressBar = ProgressDialog(context)
        progressBar.setMessage("Please Wait")
        progressBar.show()
        apiService.getData(2).enqueue(object : Callback<ResponseModel> {
            override fun onResponse(call: Call<ResponseModel>, response: Response<ResponseModel>) {
                progressBar.dismiss()
                response.body()?.run {
                    responseModel = this

                    responseModel.data?.apply {
                        tvEmail.text = responseModel.data!!.email
                        tvName.text = responseModel.data!!.firstName
                        tvLastName.text = responseModel.data!!.lastName
                    }
                }

            }

            override fun onFailure(call: Call<ResponseModel>, t: Throwable) {

            }
        })
    }
}