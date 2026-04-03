package com.adzinka.subtracker.model

data class Subscription(
    val id: Int,
    val name: String,
    val category: Category,
    val nextPaymentDate: String,
    val price: Int,
    val currency: String = "CZK",
    val billingPeriod: BillingPeriod = BillingPeriod.MONTHLY,
    val status: SubscriptionStatus = SubscriptionStatus.ACTIVE,
    val notes: String? = null
)

enum class SubscriptionStatus {
    ACTIVE, PAUSED, SOON
}