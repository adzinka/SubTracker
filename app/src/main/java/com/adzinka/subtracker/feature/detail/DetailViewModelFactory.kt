package com.adzinka.subtracker.feature.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.adzinka.subtracker.data.repository.SubscriptionRepository

class DetailViewModelFactory(
    private val subscriptionId: Int,
    private val repository: SubscriptionRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return DetailViewModel(subscriptionId) as T
    }
}