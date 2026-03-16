package com.adzinka.subtracker.feature.subscriptions.model

data class Payment(
    val id: Int,
    val date: String,
    val amount: Int,
    val currency: String = "CZK",
    val status: PaymentStatus
)

enum class PaymentStatus { PLANNED, PAID }
