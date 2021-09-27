package com.example.moneymanager.ViewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.moneymanager.Repository.MoneyRepo

class MoneyViewModelFactory(val repo: MoneyRepo):ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MoneyViewModel(repo) as T
    }
}