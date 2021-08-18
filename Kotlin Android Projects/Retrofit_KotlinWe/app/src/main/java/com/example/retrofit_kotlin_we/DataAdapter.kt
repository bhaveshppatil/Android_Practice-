package com.example.retrofit_kotlin_we

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class DataAdapter(val responseList: List<ResponseModel>) : RecyclerView.Adapter<DataViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return DataViewHolder(view)
    }

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        val model: ResponseModel = responseList[position]
        holder.setData(model)

    }

    override fun getItemCount(): Int {
        return responseList.size
    }
}