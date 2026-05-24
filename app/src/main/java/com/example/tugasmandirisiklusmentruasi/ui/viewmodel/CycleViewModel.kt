package com.example.tugasmandirisiklusmentruasi.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.tugasmandirisiklusmentruasi.DailyLog
import com.example.tugasmandirisiklusmentruasi.data.repository.CycleRepository
import kotlinx.coroutines.launch

class CycleViewModel(private val repository: CycleRepository) : ViewModel() {

    val dailyLogs = repository.getDailyLogs().asLiveData()

    fun saveLog(log: DailyLog) {
        viewModelScope.launch {
            repository.saveLog(log)
        }
    }
}

class CycleViewModelFactory(private val repository: CycleRepository) : ViewModelProvider.Factory {
    override fun <T : androidx.lifecycle.ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CycleViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return CycleViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
