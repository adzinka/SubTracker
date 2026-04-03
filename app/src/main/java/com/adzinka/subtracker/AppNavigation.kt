package com.adzinka.subtracker

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.adzinka.subtracker.feature.detail.DetailScreen
import com.adzinka.subtracker.feature.edit.EditScreen
import com.adzinka.subtracker.feature.subscriptions.SubscriptionsScreen

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
                        },
                        onAddClick = {
                            backStack.add(EditRoute())
                        }
                    )
                }
                is DetailRoute -> NavEntry(key) {
                    DetailScreen(
                        subscriptionId = key.subscriptionId,
                        onBackClick = { backStack.removeLastOrNull() },
                        onEditClick = { backStack.add(EditRoute(key.subscriptionId)) }
                    )
                }
                is EditRoute -> NavEntry(key) {
                    EditScreen(
                        subscriptionId = key.subscriptionId,
                        onBackClick = { backStack.removeLastOrNull() }
                    )
                }
                else -> NavEntry(Unit as NavKey) { Text("Unknown route") }
            }
        }
    )
}