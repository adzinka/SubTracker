package com.adzinka.subtracker.feature.subscriptions

import com.adzinka.subtracker.model.Category
import com.adzinka.subtracker.model.FilterStatus
import com.adzinka.subtracker.model.SubscriptionStatus

sealed class SubscriptionsUiState {
    object Loading : SubscriptionsUiState()
    data class Success(val data: SubscriptionsUIState) : SubscriptionsUiState()
    data class Error(val message: String) : SubscriptionsUiState()
}

data class SubscriptionsUIState(
    val totalMonth: Int,
    val currency: String,
    val soonPayments: Int,
    val filterStatus: FilterStatus = FilterStatus.ALL,
    val subscriptionsItems: List<SubscriptionsItemUIState>
)

data class SubscriptionsItemUIState(
    val name: String,
    val price: Int,
    val currency: String,
    val nextPaymentDate: String,
    val paymentPeriod: String,
    val status: SubscriptionStatus,
    val category: Category
)



