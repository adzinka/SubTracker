package com.adzinka.subtracker.feature.edit

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.adzinka.subtracker.data.repository.SubscriptionRepository
import com.adzinka.subtracker.fake.mockSubscriptions
import com.adzinka.subtracker.feature.detail.DetailViewModel
import com.adzinka.subtracker.model.BillingPeriod
import com.adzinka.subtracker.model.Category
import com.adzinka.subtracker.model.Subscription
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

@HiltViewModel(assistedFactory = EditViewModel.Factory::class)
class EditViewModel @AssistedInject constructor(
    @Assisted private val subscriptionId: Int?,
    private val repository: SubscriptionRepository
) : ViewModel() {
    @AssistedFactory
    interface Factory {
        fun create(subscriptionId: Int?): EditViewModel
    }
    private val _uiState = MutableStateFlow<EditUiState>(EditUiState.Loading)
    val uiState: StateFlow<EditUiState> = _uiState.asStateFlow()

    private val _navigateBack = MutableSharedFlow<Unit>()
    val navigateBack = _navigateBack.asSharedFlow()

    private val _navigateMainScreen = MutableSharedFlow<Unit>()
    val navigateMainScreen = _navigateMainScreen.asSharedFlow()

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
        val state = _uiState.value as? EditUiState.Success ?: return
        val form = state.form
        val subscription = Subscription(
            id = form.id,
            name = form.name,
            category = form.category,
            price = form.price.toInt(),
            currency = form.currency,
            billingPeriod = form.billingPeriod,
            nextPaymentDate = form.nextPaymentDate,
            notes = form.notes.ifBlank { null },
            reminderDays = if (form.reminderEnabled) form.reminderDays else null
        )
        viewModelScope.launch {
            if (subscriptionId != null) {
                repository.updateSubscription(subscription)
            } else {
                repository.insertSubscription(subscription)
            }
            _navigateBack.emit(Unit)
        }
    }

    fun onDeleteClick() {
        val state = _uiState.value as? EditUiState.Success ?: return
        val form = state.form
        val subscription = Subscription(
            id = form.id,
            name = form.name,
            category = form.category,
            price = form.price.toInt(),
            currency = form.currency,
            billingPeriod = form.billingPeriod,
            nextPaymentDate = form.nextPaymentDate,
            notes = form.notes.ifBlank { null },
            reminderDays = if (form.reminderEnabled) form.reminderDays else null
        )
        viewModelScope.launch {
            repository.deleteSubscription(subscription)
            _navigateMainScreen.emit(Unit)
        }
    }
}