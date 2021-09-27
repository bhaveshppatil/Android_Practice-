package com.example.moneymanager.Model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Money_Manager")
data class MoneyModel(
    @ColumnInfo(name = "task_name") var taskName: String,
    @ColumnInfo(name = "decs") var decs: String,
    @ColumnInfo(name = "date") var date: String,
    @ColumnInfo(name = "total_income") var total_income: Int,
    @ColumnInfo(name = "task_amount") var task_amount: Int
) {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int? = null
}

/*
 var id = 0
    var totalAmount = 0
    var activityAmount = 0
    var name = ""
    var date = ""
    var decs = ""
 */

