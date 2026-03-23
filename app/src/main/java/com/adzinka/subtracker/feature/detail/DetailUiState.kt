package com.adzinka.subtracker.feature.detail

import com.adzinka.subtracker.model.Payment
import com.adzinka.subtracker.model.Subscription

sealed class DetailUiState {
    object Loading : DetailUiState()
    data class Success(
        val subscription: Subscription,
        val payments: List<Payment>
    ) : DetailUiState()
    data class Error(val message: String) : DetailUiState()
}