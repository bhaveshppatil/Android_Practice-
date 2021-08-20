package com.example.kotlinscopingfunctionsyou

import android.app.AlertDialog
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_layout.view.*

class DataViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

    fun setData(dataModel: DataModel) {
        view.apply {
            tvEmail.text = dataModel.email
            tvID.text = dataModel.id.toString()
            tvName.text = dataModel.firstName
            Glide.with(ivProfile).load(dataModel.avatar).into(ivProfile)

            cardView.setOnClickListener {
                val  alertDialog = AlertDialog.Builder(context)
                alertDialog.setTitle("User Name - ${dataModel.firstName} ")
                alertDialog.setMessage("User email ${dataModel.email}")
                alertDialog.setCancelable(true).show()

                alertDialog.show()
            }
        }
    }
}