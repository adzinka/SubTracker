package com.adzinka.subtracker.model

import androidx.compose.ui.graphics.Color
import com.adzinka.subtracker.feature.subscriptions.SubscriptionsItemUIState

data class Subscription(
    val id: Int,
    val name: String,
    val category: Category,
    val nextPaymentDate: String,
    val price: Int,
    val currency: String = "CZK",
    val period: String = "monthly",
    val status: SubscriptionStatus = SubscriptionStatus.ACTIVE,
)

fun Subscription.toUIState() = SubscriptionsItemUIState(
    name = name,
    price = price,
    currency = currency,
    nextPaymentDate = nextPaymentDate,
    paymentPeriod = "měsíčně",
    status = status,
    category = category
)

enum class SubscriptionStatus {
    ACTIVE, PAUSED, SOON
}