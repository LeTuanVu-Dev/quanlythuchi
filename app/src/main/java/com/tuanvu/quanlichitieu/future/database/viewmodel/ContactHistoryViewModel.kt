package com.its.colorphone.database.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.tuanvu.quanlichitieu.future.database.entity.ContactFile
import com.tuanvu.quanlichitieu.future.database.repositories.ContactHistoryRepository
import kotlinx.coroutines.launch

class ContactHistoryViewModel(private val repository: ContactHistoryRepository) : ViewModel() {
    val allContactHistory: LiveData<List<ContactFile>> =
        repository.allContactHistories.asLiveData()
    fun insert(contactFile: ContactFile) {
        viewModelScope.launch {
            repository.insert(contactFile)
        }
    }
    fun update(contactFile: ContactFile) {
        viewModelScope.launch {
            repository.update(contactFile)
        }
    }

    fun delete(contactFile: ContactFile) {
        viewModelScope.launch {
            repository.delete(contactFile)
        }
    }
}

class ContactViewModelFactory(private val repository: ContactHistoryRepository) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ContactHistoryViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return ContactHistoryViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}

