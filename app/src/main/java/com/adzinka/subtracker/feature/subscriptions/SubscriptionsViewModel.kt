package com.adzinka.subtracker.feature.subscriptions

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.adzinka.subtracker.data.repository.SubscriptionRepository
import com.adzinka.subtracker.model.FilterStatus
import com.adzinka.subtracker.model.Subscription
import com.adzinka.subtracker.model.SubscriptionStatus
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn

@HiltViewModel
class SubscriptionsViewModel @Inject constructor(
    repository: SubscriptionRepository
) : ViewModel() {

    private val _filterStatus = MutableStateFlow(FilterStatus.ALL)
    val uiState: StateFlow<SubscriptionsUiState> = combine(
        repository.getAllSubscriptions(),
        _filterStatus
    ) { subscriptions, filter ->

        SubscriptionsUiState.Success(
            data = SubscriptionsListUiState(
                totalMonth = subscriptions.sumOf { it.price },
                currency = "CZK",
                soonPayments = subscriptions.count { it.status == SubscriptionStatus.SOON },
                filterStatus = filter,
                subscriptionsItems = subscriptions.map { subscriptionToUIState(it) }
            )
        ) as SubscriptionsUiState
    }
    .onStart { emit(SubscriptionsUiState.Loading)  }
    .catch { emit(SubscriptionsUiState.Error(it.message ?: "Unknown error")) }
    .stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5_000),
        initialValue = SubscriptionsUiState.Loading
    )

    fun onFilterSelected(filter: FilterStatus) {
        _filterStatus.value = filter
    }

    private fun subscriptionToUIState(subscription: Subscription) = SubscriptionsItemUiState(
        id = subscription.id,
        name = subscription.name,
        price = subscription.price,
        currency = subscription.currency,
        nextPaymentDate = subscription.nextPaymentDate,
        billingPeriod = subscription.billingPeriod,
        status = subscription.status,
        category = subscription.category
    )


}