package com.adzinka.subtracker.feature.subscriptions

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.adzinka.subtracker.data.repository.SubscriptionRepository
import com.adzinka.subtracker.model.FilterStatus
import com.adzinka.subtracker.model.Subscription
import com.adzinka.subtracker.model.SubscriptionStatus
import com.adzinka.subtracker.model.monthlyTotal
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import java.time.Clock
import java.time.LocalDate

@HiltViewModel
class SubscriptionsViewModel @Inject constructor(
    repository: SubscriptionRepository,
    private val clock: Clock
) : ViewModel() {

    private val _filterStatus = MutableStateFlow(FilterStatus.ALL)
    val uiState: StateFlow<SubscriptionsUiState> = combine(
        repository.getAllSubscriptions(),
        _filterStatus
    ) { subscriptions, filter ->
        val today = LocalDate.now(clock)

        val visible = when (filter) {
            FilterStatus.ALL -> subscriptions
            FilterStatus.ACTIVE -> subscriptions.filter { it.status == SubscriptionStatus.ACTIVE }
            FilterStatus.PAUSED -> subscriptions.filter { it.status == SubscriptionStatus.PAUSED }
            FilterStatus.SOON -> subscriptions.filter { it.isSoon(today) }
        }

        SubscriptionsUiState.Success(
            data = SubscriptionsListUiState(
                totalMonth = subscriptions.monthlyTotal(),
                currency = "CZK",
                soonPayments = subscriptions.count { it.isSoon(today) },
                filterStatus = filter,
                subscriptionsItems = visible.map { it.toItemUiState(today) }
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
}