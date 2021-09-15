package com.example.moneymanager.Adapter

import com.example.moneymanager.Model.MoneyModel

interface ClickListener {
    fun editDetails(moneyModel: MoneyModel)
    fun deleteActivity(moneyModel: MoneyModel)

}