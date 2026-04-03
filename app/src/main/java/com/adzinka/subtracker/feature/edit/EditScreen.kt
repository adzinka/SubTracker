package com.adzinka.subtracker.feature.edit

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.adzinka.subtracker.fake.mockSubscriptions
import com.adzinka.subtracker.feature.edit.components.BillingPeriodSelector
import com.adzinka.subtracker.feature.edit.components.CategoryPicker
import com.adzinka.subtracker.feature.edit.components.DateField
import com.adzinka.subtracker.feature.edit.components.DeleteButton
import com.adzinka.subtracker.feature.edit.components.EditTopBar
import com.adzinka.subtracker.feature.edit.components.NameField
import com.adzinka.subtracker.feature.edit.components.NotesField
import com.adzinka.subtracker.feature.edit.components.PriceRow
import com.adzinka.subtracker.feature.edit.components.ReminderSection
import com.adzinka.subtracker.model.BillingPeriod
import com.adzinka.subtracker.model.Category

@Composable
fun EditScreen(
    subscriptionId: Int,
    onBackClick: () -> Unit,
    viewModel: EditViewModel = viewModel(
        factory = EditViewModelFactory(subscriptionId)
    )
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    when (val state = uiState) {
        is EditUiState.Loading -> { /* TODO */ }
        is EditUiState.Error -> { /* TODO */ }
        is EditUiState.Success -> {
            EditContent(
                form = state.form,
                onBackClick = onBackClick,
                onSaveClick = viewModel::onSaveClick,
                onNameChange = viewModel::onNameChange,
                onCategorySelected = viewModel::onCategorySelected,
                onPriceChange = viewModel::onPriceChange,
                onCurrencyChange = viewModel::onCurrencyChange,
                onBillingPeriodSelected = viewModel::onBillingPeriodSelected,
                onDateChange = viewModel::onDateChange,
                onNotesChange = viewModel::onNotesChange,
                onReminderToggle = viewModel::onReminderToggle,
                onReminderDaysSelected = viewModel::onReminderDaysSelected,
                onDeleteClick = viewModel::onDeleteClick
            )
        }
    }
}

@Composable
private fun EditContent(
    form: EditFormState,
    onBackClick: () -> Unit,
    onSaveClick: () -> Unit,
    onNameChange: (String) -> Unit,
    onCategorySelected: (Category) -> Unit,
    onPriceChange: (String) -> Unit,
    onCurrencyChange: (String) -> Unit,
    onBillingPeriodSelected: (BillingPeriod) -> Unit,
    onDateChange: (String) -> Unit,
    onNotesChange: (String) -> Unit,
    onReminderToggle: (Boolean) -> Unit,
    onReminderDaysSelected: (Int) -> Unit,
    onDeleteClick: () -> Unit
) {
    Column(modifier = Modifier.fillMaxSize()) {
        EditTopBar(onBackClick = onBackClick, onSaveClick = onSaveClick)

        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            NameField(value = form.name, onValueChange = onNameChange)
            CategoryPicker(selected = form.category, onSelected = onCategorySelected)
            PriceRow(
                price = form.price, onPriceChange = onPriceChange,
                currency = form.currency, onCurrencyChange = onCurrencyChange
            )
            BillingPeriodSelector(selected = form.billingPeriod, onSelected = onBillingPeriodSelected)
            DateField(value = form.nextPaymentDate, onValueChange = onDateChange)
            NotesField(value = form.notes, onValueChange = onNotesChange)
            ReminderSection(
                enabled = form.reminderEnabled,
                days = form.reminderDays,
                onToggle = onReminderToggle,
                onDaysSelected = onReminderDaysSelected
            )
            DeleteButton(onClick = onDeleteClick)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun EditContentPreview() {
    val subscription = mockSubscriptions[0]

    EditContent(
        form = EditFormState(
            id = subscription.id,
            name = subscription.name,
            category = subscription.category,
            price = subscription.price.toString(),
            currency = subscription.currency,
            billingPeriod = subscription.billingPeriod,
            nextPaymentDate = subscription.nextPaymentDate,
            notes = subscription.notes.toString(),
            reminderEnabled = true,
            reminderDays = subscription.reminderDays ?: 3
        ),
        onBackClick = {},
        onSaveClick = {},
        onNameChange = {},
        onCategorySelected = {},
        onPriceChange = {},
        onCurrencyChange = {},
        onBillingPeriodSelected = {},
        onDateChange = {},
        onNotesChange = {},
        onReminderToggle = {},
        onReminderDaysSelected = {},
        onDeleteClick = {}
    )

}