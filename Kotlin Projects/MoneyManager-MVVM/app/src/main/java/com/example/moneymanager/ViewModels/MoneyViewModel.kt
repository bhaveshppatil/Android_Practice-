package com.example.moneymanager.ViewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.moneymanager.Model.MoneyModel
import com.example.moneymanager.Repository.MoneyRepo

class MoneyViewModel(private val repo: MoneyRepo) : ViewModel() {

    fun addTask(moneyModel: MoneyModel) {
        repo.addTaskToRoom(moneyModel)
    }

    fun getTask(): LiveData<List<MoneyModel>> {
        return repo.getAllTask()
    }

    fun deleteTask(moneyModel: MoneyModel) {
        repo.deleteTask(moneyModel)
    }

    fun updateTask(moneyModel: MoneyModel) {
        repo.updateTask(moneyModel)
    }
}