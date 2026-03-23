package com.adzinka.subtracker.model

import com.adzinka.subtracker.feature.subscriptions.SubscriptionsItemUIState

data class Subscription(
    val id: Int,
    val name: String,
    val nextPaymentDate: String,
    val price: Int,
    val currency: String = "CZK",
    val period: String = "monthly",
    val status: SubscriptionStatus = SubscriptionStatus.ACTIVE,
    val category: Category,
    val notes: String? = null
) {
    // TODO move to Mapper
    fun toUIState() = SubscriptionsItemUIState(
        name = name,
        price = price,
        currency = currency,
        nextPaymentDate = nextPaymentDate,
        paymentPeriod = period,
        status = status,
        category = category
    )
}

enum class SubscriptionStatus {
    ACTIVE, PAUSED, SOON
}