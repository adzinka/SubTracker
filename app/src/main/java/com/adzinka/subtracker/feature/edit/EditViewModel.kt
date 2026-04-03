package com.adzinka.subtracker.feature.edit

import androidx.lifecycle.ViewModel
import com.adzinka.subtracker.fake.mockSubscriptions
import com.adzinka.subtracker.model.BillingPeriod
import com.adzinka.subtracker.model.Category
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class EditViewModel(private val subscriptionId: Int?) : ViewModel() {
    private val _uiState = MutableStateFlow<EditUiState>(EditUiState.Loading)
    val uiState: StateFlow<EditUiState> = _uiState.asStateFlow()

    init { load() }

    private fun load() {

        _uiState.value = if (subscriptionId != null) {
            val sub = mockSubscriptions.find { it.id == subscriptionId }
            if (sub != null) EditUiState.Success(
                EditFormState(
                    id = sub.id,
                    name = sub.name,
                    category = sub.category,
                    price = sub.price.toString(),
                    currency = sub.currency,
                    billingPeriod = sub.billingPeriod,
                    nextPaymentDate = sub.nextPaymentDate,
                    notes = sub.notes ?: "",
                    reminderEnabled = sub.reminderDays != null,
                    reminderDays = sub.reminderDays ?: 1
                )
            )
            else EditUiState.Error("Subscription not found")
        } else {
            EditUiState.Success(EditFormState(id = -1))
        }
    }

    private fun update(block: EditFormState.() -> EditFormState) {
        val current = _uiState.value
        if (current is EditUiState.Success) {
            _uiState.value = EditUiState.Success(current.form.block())
        }
    }

    fun onNameChange(value: String) = update { copy(name = value) }
    fun onCategorySelected(value: Category) = update { copy(category = value) }
    fun onPriceChange(value: String) = update { copy(price = value) }
    fun onCurrencyChange(value: String) = update { copy(currency = value) }
    fun onBillingPeriodSelected(value: BillingPeriod) = update { copy(billingPeriod = value) }
    fun onDateChange(value: String) = update { copy(nextPaymentDate = value) }
    fun onNotesChange(value: String) = update { copy(notes = value) }
    fun onReminderToggle(enabled: Boolean) = update { copy(reminderEnabled = enabled) }
    fun onReminderDaysSelected(days: Int) = update { copy(reminderDays = days) }

    fun onSaveClick() {
        // TODO
    }

    fun onDeleteClick() {
        // TODO
    }
}