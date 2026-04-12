package com.adzinka.subtracker.feature.subscriptions

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.adzinka.subtracker.data.repository.SubscriptionRepository

class SubscriptionsViewModelFactory(
    private val repository: SubscriptionRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return SubscriptionsViewModel(repository) as T
    }
}