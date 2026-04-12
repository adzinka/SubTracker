package com.adzinka.subtracker.feature.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.adzinka.subtracker.data.repository.SubscriptionRepository
import com.adzinka.subtracker.fake.mockPayments
import com.adzinka.subtracker.fake.mockSubscriptions
import com.adzinka.subtracker.feature.detail.components.DetailUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.launch

class DetailViewModel(
    private val subscriptionId: Int,
    private val repository: SubscriptionRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow<DetailUiState>(DetailUiState.Loading)
    val uiState: StateFlow<DetailUiState> = _uiState.asStateFlow()

    init {
        loadSubscription()
    }

    private fun loadSubscription() {
        viewModelScope.launch {
            combine(
                repository.getSubscriptionById(subscriptionId),
                repository.getPaymentsBySubscriptionId(subscriptionId)
            ) { subscription, payments ->
                DetailUiState.Success(
                    subscription = subscription,
                    payments = payments
                )
            }
                .catch { _uiState.value = DetailUiState.Error(it.message ?: "Unknown error") }
                .collect { _uiState.value = it }
        }
    }

    fun onPayClick() {
        // TODO
    }

    fun onPauseClick() {
        // TODO
    }
}