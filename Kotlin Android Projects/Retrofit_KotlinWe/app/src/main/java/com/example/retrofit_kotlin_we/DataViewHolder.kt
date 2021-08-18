package com.example.retrofit_kotlin_we

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_layout.view.*

class DataViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

    fun setData(responseModel: ResponseModel) {
        view.tvName.text = responseModel.name
        view.tvEmail.text = responseModel.email
        view.tvBody.text = responseModel.body
    }
}