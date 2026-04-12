package com.adzinka.subtracker.data.mapper

import com.adzinka.subtracker.data.entity.SubscriptionEntity
import com.adzinka.subtracker.model.BillingPeriod
import com.adzinka.subtracker.model.Category
import com.adzinka.subtracker.model.Subscription
import com.adzinka.subtracker.model.SubscriptionStatus

fun SubscriptionEntity.toDomainModel(): Subscription {
    return Subscription(
        id = id,
        name = name,
        category = enumValueOf<Category>(category),
        nextPaymentDate = nextPaymentDate,
        price = price,
        currency = currency,
        billingPeriod = enumValueOf<BillingPeriod>(billingPeriod),
        reminderDays = reminderDays,
        status = enumValueOf<SubscriptionStatus>(status),
        notes = notes
    )
}

fun Subscription.toEntityModel(): SubscriptionEntity {
    return SubscriptionEntity(
        id = id,
        name = name,
        category = category.name,
        nextPaymentDate = nextPaymentDate,
        price = price,
        currency = currency,
        billingPeriod = billingPeriod.name,
        reminderDays = reminderDays,
        status = status.name,
        notes = notes
    )
}
