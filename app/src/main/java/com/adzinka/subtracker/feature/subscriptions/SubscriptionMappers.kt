package com.adzinka.subtracker.feature.subscriptions

import com.adzinka.subtracker.core.ui.UrgencyState
import com.adzinka.subtracker.model.Subscription
import com.adzinka.subtracker.model.SubscriptionStatus
import java.time.LocalDate
import java.time.temporal.ChronoUnit

fun Subscription.isSoon(today: LocalDate): Boolean =
    status == SubscriptionStatus.ACTIVE &&
            ChronoUnit.DAYS.between(today, nextPaymentDate) in 0..7

fun Subscription.toUrgencyState(today: LocalDate): UrgencyState {
    if (status == SubscriptionStatus.PAUSED) return UrgencyState.Paused
    val days = ChronoUnit.DAYS.between(today, nextPaymentDate).toInt()
    return when {
        days <= 0 -> UrgencyState.Today
        days == 1 -> UrgencyState.Tomorrow
        else -> UrgencyState.Days(days)
    }
}

fun Subscription.toItemUiState(today: LocalDate) = SubscriptionsItemUiState(
    id = id,
    name = name,
    price = price,
    currency = currency,
    nextPaymentDate = nextPaymentDate,
    billingPeriod = billingPeriod,
    status = status,
    category = category,
    urgency = toUrgencyState(today)
)