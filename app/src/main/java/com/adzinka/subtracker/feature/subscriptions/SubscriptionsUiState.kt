package com.adzinka.subtracker.feature.subscriptions

import com.adzinka.subtracker.model.BillingPeriod
import com.adzinka.subtracker.model.Category
import com.adzinka.subtracker.model.FilterStatus
import com.adzinka.subtracker.model.SubscriptionStatus

sealed class SubscriptionsUiState {
    object Loading : SubscriptionsUiState()
    data class Success(val data: SubscriptionsListUiState) : SubscriptionsUiState()
    data class Error(val message: String) : SubscriptionsUiState()
}

data class SubscriptionsListUiState(
    val totalMonth: Int,
    val currency: String,
    val soonPayments: Int,
    val filterStatus: FilterStatus = FilterStatus.ALL,
    val subscriptionsItems: List<SubscriptionsItemUiState>
)

data class SubscriptionsItemUiState(
    val id: Int,
    val name: String,
    val price: Int,
    val currency: String,
    val nextPaymentDate: String,
    val billingPeriod: BillingPeriod,
    val status: SubscriptionStatus,
    val category: Category
)
