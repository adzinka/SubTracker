package com.adzinka.subtracker

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

sealed interface AppRoute : NavKey {
    @Serializable
    data object SubscriptionsRoute : AppRoute

    @Serializable
    data class DetailRoute(val subscriptionId: Int) : AppRoute

    @Serializable
    data class EditRoute(val subscriptionId: Int? = null) : AppRoute

    @Serializable
    data object StatsRoute : AppRoute

    @Serializable
    data object SettingsRoute : AppRoute
}
