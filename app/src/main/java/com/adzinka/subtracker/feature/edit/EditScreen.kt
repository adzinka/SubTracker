package com.adzinka.subtracker.feature.edit

import androidx.compose.runtime.Composable

//@Composable
//fun EditScreen(
//    subscriptionId: Int,
//    onBackClick: () -> Unit,
//    viewModel: EditViewModel = viewModel(
//        factory = EditViewModelFactory(subscriptionId)
//    )
//) {
//    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
//
//    when (val state = uiState) {
//        is EditUiState.Loading -> { /* TODO */ }
//        is EditUiState.Error -> { /* TODO */ }
//        is EditUiState.Success -> {
//            EditContent(
//                form = state.form,
//                onBackClick = onBackClick,
//                onSaveClick = viewModel::onSaveClick,
//                onNameChange = viewModel::onNameChange,
//                onCategorySelected = viewModel::onCategorySelected,
//                onPriceChange = viewModel::onPriceChange,
//                onCurrencyChange = viewModel::onCurrencyChange,
//                onBillingPeriodSelected = viewModel::onBillingPeriodSelected,
//                onDateChange = viewModel::onDateChange,
//                onNotesChange = viewModel::onNotesChange,
//                onReminderToggle = viewModel::onReminderToggle,
//                onReminderDaysSelected = viewModel::onReminderDaysSelected,
//                onDeleteClick = viewModel::onDeleteClick
//            )
//        }
//    }
//}

//@Composable
//private fun EditContent(
//    form: EditFormState,
//    onBackClick: () -> Unit,
//    onSaveClick: () -> Unit,
//    onNameChange: (String) -> Unit,
//    onCategorySelected: (Category) -> Unit,
//    onPriceChange: (String) -> Unit,
//    onCurrencyChange: (String) -> Unit,
//    onBillingPeriodSelected: (BillingPeriod) -> Unit,
//    onDateChange: (String) -> Unit,
//    onNotesChange: (String) -> Unit,
//    onReminderToggle: (Boolean) -> Unit,
//    onReminderDaysSelected: (Int) -> Unit,
//    onDeleteClick: () -> Unit
//) {
//    Column(modifier = Modifier.fillMaxSize()) {
//        EditTopBar(onBackClick = onBackClick, onSaveClick = onSaveClick)
//
//        Column(
//            modifier = Modifier
//                .fillMaxSize()
//                .verticalScroll(rememberScrollState())
//                .padding(16.dp),
//            verticalArrangement = Arrangement.spacedBy(20.dp)
//        ) {
//            NameField(value = form.name, onValueChange = onNameChange)
//            CategoryPicker(selected = form.category, onSelected = onCategorySelected)
//            PriceRow(
//                price = form.price, onPriceChange = onPriceChange,
//                currency = form.currency, onCurrencyChange = onCurrencyChange
//            )
//            BillingPeriodSelector(selected = form.billingPeriod, onSelected = onBillingPeriodSelected)
//            DateField(value = form.nextPaymentDate, onValueChange = onDateChange)
//            NotesField(value = form.notes, onValueChange = onNotesChange)
//            ReminderSection(
//                enabled = form.reminderEnabled,
//                days = form.reminderDays,
//                onToggle = onReminderToggle,
//                onDaysSelected = onReminderDaysSelected
//            )
//            DeleteButton(onClick = onDeleteClick)
//        }
//    }
//}