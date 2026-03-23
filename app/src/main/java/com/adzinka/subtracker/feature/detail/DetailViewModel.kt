package com.adzinka.subtracker.feature.detail

import androidx.lifecycle.ViewModel
import com.adzinka.subtracker.fake.mockPayments
import com.adzinka.subtracker.fake.mockSubscriptions
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class DetailViewModel(
    private val subscriptionId: Int
) : ViewModel() {

    private val _uiState = MutableStateFlow<DetailUiState>(DetailUiState.Loading)
    val uiState: StateFlow<DetailUiState> = _uiState.asStateFlow()

    init {
        loadSubscription()
    }

    private fun loadSubscription() {
        // Пока ищем в моковых данных по id
        val subscription = mockSubscriptions.find { it.id == subscriptionId }

        _uiState.value = if (subscription != null) {
            DetailUiState.Success(
                subscription = subscription,
                payments = mockPayments
            )
        } else {
            DetailUiState.Error("Subscription not found")
        }
    }

    fun onPayClick() {
        // TODO
    }

    fun onPauseClick() {
        // TODO
    }
}