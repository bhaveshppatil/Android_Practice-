package com.example.moneymanager.Model

import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import  com.example.moneymanager.R

class MoneyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    var totalAmount: TextView = itemView.findViewById(R.id.tvTotalSalary)
    var taskAmount: TextView = itemView.findViewById(R.id.tvActivityAmount)
    var date: TextView = itemView.findViewById(R.id.tvDate)
    var name: TextView = itemView.findViewById(R.id.tvName)
    var taskName: TextView = itemView.findViewById(R.id.tvActivityName)
    var balance: TextView = itemView.findViewById(R.id.tvBalanceAmount)


    var btnEdit: Button = itemView.findViewById(R.id.btnEdit);
    var btnDelete: Button = itemView.findViewById(R.id.btnDelete);


}