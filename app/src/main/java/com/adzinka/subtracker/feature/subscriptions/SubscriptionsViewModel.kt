package com.adzinka.subtracker.feature.subscriptions

import androidx.lifecycle.ViewModel
import com.adzinka.subtracker.fake.mockSubscriptions
import com.adzinka.subtracker.model.SubscriptionStatus
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class SubscriptionsViewModel : ViewModel() {
    private val _uiState = MutableStateFlow<SubscriptionsUiState>(SubscriptionsUiState.Loading)
    val uiState: StateFlow<SubscriptionsUiState> = _uiState.asStateFlow()

    init {
        loadSubscriptions()
    }

    private fun loadSubscriptions() {
        // TODO Repository
        _uiState.value = SubscriptionsUiState.Success(
            data = SubscriptionsUIState(
                totalMonth = mockSubscriptions.sumOf { it.price },
                currency = "CZK",
                soonPayments = mockSubscriptions.count { it.status == SubscriptionStatus.SOON },
                subscriptionsItems = mockSubscriptions.map { it.toUIState() }
            )
        )
    }

//    fun onFilterSelected(filter: String) {
//        val current = _uiState.value
//        if (current is SubscriptionsUiState.Success) {
//            _uiState.value = current.copy(filterStatus = filter)
//        }
//    }
}