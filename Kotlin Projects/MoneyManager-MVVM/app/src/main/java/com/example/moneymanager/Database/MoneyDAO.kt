package com.example.moneymanager.Database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.moneymanager.Model.MoneyModel

@Dao
interface MoneyDAO {

    //Insert the data into database
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addTask(moneyModel: MoneyModel)

    @Query("select * from money_manager")
    fun getTaskData() : LiveData<List<MoneyModel>>

    @Update
    fun updateTaskData(moneyModel: MoneyModel)

    @Delete
    fun deleteTask(moneyModel: MoneyModel)

}