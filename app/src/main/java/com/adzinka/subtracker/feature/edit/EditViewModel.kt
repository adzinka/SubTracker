package com.adzinka.subtracker.feature.edit

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.adzinka.subtracker.data.repository.SubscriptionRepository
import com.adzinka.subtracker.fake.mockSubscriptions
import com.adzinka.subtracker.model.BillingPeriod
import com.adzinka.subtracker.model.Category
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

class EditViewModel(
    private val subscriptionId: Int?,
    private val repository: SubscriptionRepository
) : ViewModel() {
    private val _uiState = MutableStateFlow<EditUiState>(EditUiState.Loading)
    val uiState: StateFlow<EditUiState> = _uiState.asStateFlow()

    init { load() }

    private fun load() {
        if (subscriptionId != null) {
            viewModelScope.launch {
                repository.getSubscriptionById(subscriptionId)
                    .catch { _uiState.value = EditUiState.Error(it.message ?: "Unknown error") }
                    .collect { subscription ->
                        _uiState.value = EditUiState.Success(
                            EditFormState(
                                id = subscription.id,
                                name = subscription.name,
                                category = subscription.category,
                                price = subscription.price.toString(),
                                currency = subscription.currency,
                                billingPeriod = subscription.billingPeriod,
                                nextPaymentDate = subscription.nextPaymentDate,
                                notes = subscription.notes ?: "",
                                reminderEnabled = subscription.reminderDays != null,
                                reminderDays = subscription.reminderDays ?: 1
                            )
                        )
                    }
            }
            } else {
            _uiState.value = EditUiState.Success(EditFormState(id = -1))
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