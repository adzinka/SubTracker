package com.adzinka.subtracker.feature.subscriptions

import androidx.lifecycle.ViewModel
import com.adzinka.subtracker.fake.mockSubscriptions
import com.adzinka.subtracker.model.FilterStatus
import com.adzinka.subtracker.model.Subscription
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
            data = SubscriptionsListUiState(
                totalMonth = mockSubscriptions.sumOf { it.price },
                currency = "CZK",
                soonPayments = mockSubscriptions.count { it.status == SubscriptionStatus.SOON },
                subscriptionsItems = mockSubscriptions.map { subscriptionToUIState(it) }
            )
        )
    }

    private fun subscriptionToUIState(subscription: Subscription) = SubscriptionsItemUiState(
        id = subscription.id,
        name = subscription.name,
        price = subscription.price,
        currency = subscription.currency,
        nextPaymentDate = subscription.nextPaymentDate,
        paymentPeriod = subscription.period,
        status = subscription.status,
        category = subscription.category
    )

    fun onFilterSelected(filter: FilterStatus) {
        val current = _uiState.value
        if (current is SubscriptionsUiState.Success) {
            _uiState.value = SubscriptionsUiState.Success(
                current.data.copy(filterStatus = filter)
            )
        }
    }
}