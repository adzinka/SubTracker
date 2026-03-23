package com.adzinka.subtracker

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.adzinka.subtracker.feature.detail.DetailScreen
import com.adzinka.subtracker.feature.subscriptions.SubscriptionsScreen
import com.adzinka.subtracker.model.Subscription

@Composable
fun AppNavigation() {

    val backStack = rememberNavBackStack(SubscriptionsRoute)


    NavDisplay(
        backStack = backStack,
        onBack = { backStack.removeLastOrNull() },
        entryProvider = { key ->
            when (key) {
                is SubscriptionsRoute -> NavEntry(key) {
                    SubscriptionsScreen(
                        onSubscriptionClick = { id ->
                            backStack.add(DetailRoute(id))
                        }
                    )
                }
                is DetailRoute -> NavEntry(key) {
                    DetailScreen(
                        subscriptionId = key.subscriptionId,
                        onBackClick = { backStack.removeLastOrNull() },
                        onEditClick = { /* TODO */ }
                    )
                }
                else -> NavEntry(Unit as NavKey) { Text("Unknown route") }
            }
        }
    )
}