package com.adzinka.subtracker.model

fun Subscription.monthlyPrice(): Int = when (billingPeriod) {
    BillingPeriod.MONTHLY -> price
    // TODO: integer division loses precision; migrate to Long minor units
    BillingPeriod.YEARLY -> price / 12
    BillingPeriod.WEEKLY -> price * 52 / 12
}

fun List<Subscription>.monthlyTotal(): Int =
    filter { it.status == SubscriptionStatus.ACTIVE }
        .sumOf { it.monthlyPrice() }

