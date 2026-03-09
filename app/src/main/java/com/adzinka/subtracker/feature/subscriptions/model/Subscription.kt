package com.adzinka.subtracker.feature.subscriptions.model

import androidx.compose.ui.graphics.Color

data class Subscription(
    val id: Int,
    val name: String,
    val category: String,
    val nextPaymentDate: String,
    val price: Int,
    val currency: String = "CZK",
    val period: String = "monthly",
    val status: SubscriptionStatus = SubscriptionStatus.ACTIVE,
    val iconEmoji: String,
    val iconColor: Color
)

enum class SubscriptionStatus {
    ACTIVE, PAUSED, SOON
}