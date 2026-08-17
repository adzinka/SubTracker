package com.adzinka.subtracker.model

import java.time.LocalDate

data class Subscription(
    val id: Int,
    val name: String,
    val category: Category,
    val nextPaymentDate: LocalDate,
    val price: Int,
    val currency: String = "CZK",
    val billingPeriod: BillingPeriod = BillingPeriod.MONTHLY,
    val reminderDays: Int? = null,
    val status: SubscriptionStatus = SubscriptionStatus.ACTIVE,
    val notes: String? = null
)

enum class SubscriptionStatus { ACTIVE, PAUSED }