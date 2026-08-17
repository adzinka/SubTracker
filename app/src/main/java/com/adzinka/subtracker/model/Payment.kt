package com.adzinka.subtracker.model

import java.time.LocalDate

data class Payment(
    val id: Int,
    val subscriptionId: Int,
    val date: LocalDate,
    val amount: Int,
    val currency: String = "CZK",
    val status: PaymentStatus
)

enum class PaymentStatus { PLANNED, PAID }
