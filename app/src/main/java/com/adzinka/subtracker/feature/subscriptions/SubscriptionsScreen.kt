package com.adzinka.subtracker.feature.subscriptions

import androidx.compose.runtime.getValue
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.adzinka.subtracker.SubTrackerApplication
import com.adzinka.subtracker.model.SubscriptionStatus
import com.adzinka.subtracker.core.ui.theme.AppColors
import com.adzinka.subtracker.feature.subscriptions.components.FilterRow
import com.adzinka.subtracker.feature.subscriptions.components.SubscriptionCard
import com.adzinka.subtracker.feature.subscriptions.core.ui.SubscriptionsHeader
import com.adzinka.subtracker.feature.subscriptions.components.AddButton
import com.adzinka.subtracker.model.FilterStatus

@Composable
fun SubscriptionsScreen(
    onSubscriptionClick: (Int) -> Unit,
    onAddClick: () -> Unit,
    viewModel: SubscriptionsViewModel = viewModel(
        factory = SubscriptionsViewModelFactory(
            (LocalContext.current.applicationContext as SubTrackerApplication).repository
        )
    )
) {

    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    when (val state = uiState) {
        is SubscriptionsUiState.Loading -> {
            Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                CircularProgressIndicator()
            }
        }
        is SubscriptionsUiState.Success -> {
            SubscriptionsContent(
                data = state.data,
                onFilterSelected = viewModel::onFilterSelected,
                onSubscriptionClick = onSubscriptionClick,
                onAddClick = onAddClick
            )
        }
        is SubscriptionsUiState.Error -> {
            Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Text(state.message)
            }
        }
    }

}

@Composable
private fun SubscriptionsContent(
    data: SubscriptionsListUiState,
    onFilterSelected: (FilterStatus) -> Unit,
    onSubscriptionClick: (Int) -> Unit,
    onAddClick: () -> Unit
) {

    val filteredSubscriptions = remember(data.filterStatus, data.subscriptionsItems) {
        when (data.filterStatus) {
            FilterStatus.ALL -> data.subscriptionsItems
            FilterStatus.ACTIVE -> data.subscriptionsItems.filter { it.status == SubscriptionStatus.ACTIVE }
            FilterStatus.PAUSED -> data.subscriptionsItems.filter { it.status == SubscriptionStatus.PAUSED }
            FilterStatus.SOON -> data.subscriptionsItems.filter { it.status == SubscriptionStatus.SOON }
        }
    }

    Scaffold(
        floatingActionButton = {
            AddButton(onClick = onAddClick)
        },
        containerColor = AppColors.Background
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            SubscriptionsHeader(
                totalMonthly = data.totalMonth,
                currency = data.currency,
                upcomingCount = data.soonPayments
            )

            Spacer(modifier = Modifier.height(16.dp))

            FilterRow(
                selectedFilter = data.filterStatus,
                soonCount = data.soonPayments,
                onFilterSelected = onFilterSelected
            )

            Spacer(modifier = Modifier.height(8.dp))

            LazyColumn(
                modifier = Modifier
                    .weight(1f),
                contentPadding = PaddingValues(
                    start = 16.dp,
                    end = 16.dp,
                    top = 8.dp,
                    bottom = 88.dp
                ),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(
                    items = filteredSubscriptions,
                    key = { it.id }
                ) { item ->
                    SubscriptionCard(
                        subscription = item,
                        onClick = { onSubscriptionClick(item.id)}
                    )
                }
            }
        }
    }
}

//@Preview(showBackground = true, showSystemUi = true)
//@Composable
//fun SubscriptionsScreenPreview() {
//    MaterialTheme {
//        SubscriptionsScreen(
//            onSubscriptionClick = {}
//        )
//    }
//}
