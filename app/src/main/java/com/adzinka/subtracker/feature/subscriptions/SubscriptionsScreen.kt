package com.adzinka.subtracker.feature.subscriptions

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.adzinka.subtracker.fake.mockSubscriptions
import com.adzinka.subtracker.model.SubscriptionStatus
import com.adzinka.subtracker.core.ui.theme.AppColors
import com.adzinka.subtracker.feature.subscriptions.components.FilterRow
import com.adzinka.subtracker.feature.subscriptions.core.ui.SubscriptionCard
import com.adzinka.subtracker.feature.subscriptions.core.ui.SubscriptionsHeader
import com.adzinka.subtracker.feature.subscriptions.core.ui.components.AddButton

@Composable
fun SubscriptionsScreen() {

    var selectedFilter by remember { mutableStateOf("All") }

    val filteredSubscriptions = remember(selectedFilter, mockSubscriptions) {
        when (selectedFilter) {
            "Active" -> mockSubscriptions.filter { it.status == SubscriptionStatus.ACTIVE }
            "Paused" -> mockSubscriptions.filter { it.status == SubscriptionStatus.PAUSED }
            "Soon" -> mockSubscriptions.filter { it.status == SubscriptionStatus.SOON }
            else -> mockSubscriptions
        }
    }

    val soonCount = mockSubscriptions.count { it.status == SubscriptionStatus.SOON }

    Scaffold(
        floatingActionButton = {
            AddButton(onClick = { /* TODO: Navigate to add screen */ })
        },
        containerColor = AppColors.Background
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            SubscriptionsHeader(
                totalMonthly = mockSubscriptions.sumOf { it.price },
                upcomingCount = soonCount
            )

            Spacer(modifier = Modifier.height(16.dp))

            FilterRow(
                selectedFilter = selectedFilter,
                soonCount = soonCount,
                onFilterSelected = { selectedFilter = it }
            )

            Spacer(modifier = Modifier.height(8.dp))

            LazyColumn(
                contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(
                    items = filteredSubscriptions,
                    key = { it.id }
                ) { subscription ->
                    SubscriptionCard(subscription = subscription)
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SubscriptionsScreenPreview() {
    MaterialTheme {
        SubscriptionsScreen()
    }
}