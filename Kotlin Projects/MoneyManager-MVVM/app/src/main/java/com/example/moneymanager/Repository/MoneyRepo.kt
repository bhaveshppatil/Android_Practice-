package com.example.moneymanager.Repository

import androidx.lifecycle.LiveData
import com.example.moneymanager.Database.MoneyDAO
import com.example.moneymanager.Model.MoneyModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MoneyRepo(val moneyDAO: MoneyDAO) {

    fun addTaskToRoom(moneyModel: MoneyModel) {
        CoroutineScope(Dispatchers.IO).launch {
            moneyDAO.addTask(moneyModel)
        }
    }

    fun getAllTask(): LiveData<List<MoneyModel>> {
        return moneyDAO.getTaskData()
    }

    fun updateTask(moneyModel: MoneyModel){
        CoroutineScope(Dispatchers.IO).launch {
            moneyDAO.updateTaskData(moneyModel)
        }
    }
    fun deleteTask(moneyModel: MoneyModel){
        CoroutineScope(Dispatchers.IO).launch {
            moneyDAO.deleteTask(moneyModel)
        }
    }
}