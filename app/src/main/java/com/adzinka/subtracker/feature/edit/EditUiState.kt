package com.adzinka.subtracker.feature.edit

import com.adzinka.subtracker.model.BillingPeriod
import com.adzinka.subtracker.model.Category

sealed class EditUiState {
    object Loading : EditUiState()
    data class Success(val form: EditFormState) : EditUiState()
    data class Error(val message: String) : EditUiState()
}

data class EditFormState(
    val id: Int,
    val name: String = "",
    val category: Category = Category.STREAMING,
    val price: String = "",
    val currency: String = "CZK",
    val billingPeriod: BillingPeriod = BillingPeriod.MONTHLY,
    val nextPaymentDate: String = "",
    val notes: String = "",
    val reminderEnabled: Boolean = false,
    val reminderDays: Int = 1
)
