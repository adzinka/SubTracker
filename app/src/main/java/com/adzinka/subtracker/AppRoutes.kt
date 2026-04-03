package com.adzinka.subtracker

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

@Serializable
data object SubscriptionsRoute : NavKey

@Serializable
data class DetailRoute(val subscriptionId: Int) : NavKey

@Serializable
data class EditRoute(val subscriptionId: Int? = null) : NavKey