package com.example.moneymanager.Model

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.moneymanager.ClickListener
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

    override fun onBindViewHolder(holder: MoneyViewHolder, position: Int) {

        val moneyModel = moneyModelList.get(position)
        holder.name.text = "Hello!!, ${moneyModel.name}"
        holder.date.text = moneyModel.date
        holder.taskName.text = moneyModel.decs
        holder.taskAmount.text = "₹ " + moneyModel.activityAmount.toString()
        holder.totalAmount.text = "₹ " + (moneyModel.totalAmount).toString()
        holder.balance.text = "₹ " + (moneyModel.totalAmount - moneyModel.activityAmount).toString()

        holder.btnEdit.setOnClickListener {
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

