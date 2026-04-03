package com.adzinka.subtracker.feature.edit

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class EditViewModelFactory(
    private val subscriptionId: Int
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return EditViewModel(subscriptionId) as T
    }
}