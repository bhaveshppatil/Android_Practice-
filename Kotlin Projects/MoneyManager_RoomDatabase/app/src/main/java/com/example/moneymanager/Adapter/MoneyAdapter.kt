package com.example.moneymanager.Adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.moneymanager.Model.MoneyModel
import com.example.moneymanager.R

class MoneyAdapter(
    val context: Context,
    val moneyModelList: MutableList<MoneyModel>,
    val clickListener: ClickListener
) : RecyclerView.Adapter<MoneyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoneyViewHolder {
        val inflater = LayoutInflater.from(context)
        val view: View = inflater.inflate(R.layout.income_item_layout, parent, false)
        return MoneyViewHolder(view)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: MoneyViewHolder, position: Int) {

        val moneyModel = moneyModelList[position]
        holder.name.text = "Hello!!, ${moneyModel.taskName}"
        holder.date.text = moneyModel.date
        holder.taskName.text = moneyModel.decs
        holder.taskAmount.text = "₹ " + moneyModel.task_amount.toString()
        holder.totalAmount.text = "₹ " + (moneyModel.total_income).toString()
        holder.balance.text = "₹ " + (moneyModel.total_income - moneyModel.task_amount).toString()

        holder.btnEdit.setOnClickListener {
            holder.balance.text = "₹ " + (moneyModel.total_income - moneyModel.task_amount).toString()
            clickListener.editDetails(moneyModel)
        }
        holder.btnDelete.setOnClickListener {
            clickListener.deleteActivity(moneyModel)
        }
    }

    override fun getItemCount(): Int {
        return moneyModelList.size
    }
}

