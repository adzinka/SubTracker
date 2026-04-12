package com.adzinka.subtracker.data.mapper

import com.adzinka.subtracker.data.local.entity.PaymentEntity
import com.adzinka.subtracker.model.Payment
import com.adzinka.subtracker.model.PaymentStatus

fun PaymentEntity.toDomainModel(): Payment {
    return Payment(
        id = id,
        subscriptionId = subscriptionId,
        date = date,
        amount = amount,
        currency = currency,
        status = enumValueOf<PaymentStatus>(status)
    )
}

fun Payment.toEntityModel(): PaymentEntity {
    return PaymentEntity(
        id = id,
        subscriptionId = subscriptionId,
        date = date,
        amount = amount,
        currency = currency,
        status = status.name
    )
}