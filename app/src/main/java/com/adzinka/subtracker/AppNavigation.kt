package com.adzinka.subtracker

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.adzinka.subtracker.core.ui.theme.AppColors
import com.adzinka.subtracker.feature.calendar.CalendarScreen
import com.adzinka.subtracker.feature.detail.DetailScreen
import com.adzinka.subtracker.feature.edit.EditScreen
import com.adzinka.subtracker.feature.settings.SettingsScreen
import com.adzinka.subtracker.feature.stats.StatsScreen
import com.adzinka.subtracker.feature.subscriptions.SubscriptionsScreen

@Composable
fun AppNavigation() {

    val backStack = rememberNavBackStack(SubscriptionsRoute)

    val currentRoot by remember {
        derivedStateOf { backStack.firstOrNull() }
    }

    val showBottomBar by remember {
        derivedStateOf { backStack.size <= 1 }
    }

    Scaffold(
        bottomBar = {
            if (showBottomBar) {
                AppBottomBar(
                    currentRoot = currentRoot,
                    onTabSelected = { route ->
                        backStack.clear()
                        backStack.add(route)
                    }
                )
            }
        }
    ) { _ ->
        NavDisplay(
            backStack = backStack,
            onBack = { backStack.removeLastOrNull() },
            entryProvider = { key ->
                when (key) {
                    is SubscriptionsRoute -> NavEntry(key) {
                        SubscriptionsScreen(
                            onSubscriptionClick = { id -> backStack.add(DetailRoute(id)) },
                            onAddClick = { backStack.add(EditRoute()) }
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
                            onBackClick = { backStack.removeLastOrNull() },
                            onDeleteSuccess = {
                                backStack.removeLastOrNull()
                                backStack.removeLastOrNull()
                            }
                        )
                    }
                    is CalendarRoute -> NavEntry(key) { CalendarScreen() }
                    is StatsRoute -> NavEntry(key) { StatsScreen() }
                    is SettingsRoute -> NavEntry(key) { SettingsScreen() }
                    else -> NavEntry(Unit as NavKey) { Text("Unknown route") }
                }
            }
        )
    }
}

@Composable
private fun AppBottomBar(
    currentRoot: NavKey?,
    onTabSelected: (NavKey) -> Unit
) {
    data class TabItem(val route: NavKey, val label: String, val iconRes: Int)

    val tabs = listOf(
        TabItem(SubscriptionsRoute, "Podpisy",   R.drawable.ic_subscriptions),
        TabItem(CalendarRoute,      "Kalendář",  R.drawable.ic_calendar),
        TabItem(StatsRoute,         "Přehledy",  R.drawable.ic_stats),
        TabItem(SettingsRoute,      "Nastavení", R.drawable.ic_settings)
    )

    NavigationBar(
        containerColor = AppColors.White,
        tonalElevation = 0.dp
    ) {
        tabs.forEach { tab ->
            NavigationBarItem(
                selected = currentRoot == tab.route,
                onClick = { onTabSelected(tab.route) },
                icon = {
                    Icon(
                        painter = painterResource(id = tab.iconRes),
                        contentDescription = tab.label
                    )
                },
                label = { Text(tab.label) },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = AppColors.Purple,
                    selectedTextColor = AppColors.Purple,
                    indicatorColor = AppColors.Purple.copy(alpha = 0.1f),
                    unselectedIconColor = AppColors.TextSecondary,
                    unselectedTextColor = AppColors.TextSecondary
                )
            )
        }
    }
}