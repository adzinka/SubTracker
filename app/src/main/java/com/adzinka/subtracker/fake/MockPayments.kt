package com.adzinka.subtracker.fake

import com.adzinka.subtracker.model.Payment
import com.adzinka.subtracker.model.PaymentStatus
import java.time.LocalDate

val mockPayments = listOf(
    Payment(
        1,
        1,
        LocalDate.now().plusDays(1),
        890,
        status = PaymentStatus.PLANNED
    ),
    Payment(
        2,
        1,
        LocalDate.now().plusDays(3),
        890,
        status = PaymentStatus.PLANNED
    ),
    Payment(
        3,
        1,
        LocalDate.now().plusDays(5),
        890, status = PaymentStatus.PLANNED
    ),
    Payment(
        4,
        2,
        LocalDate.now().minusMonths(1),
        890,
        status = PaymentStatus.PAID
    ),
    Payment(
        5,
        2,
        LocalDate.now().minusMonths(2),
        890,
        status = PaymentStatus.PAID
    ),
    Payment(
        6,
        2,
        LocalDate.now().minusMonths(3),
        890,
        status = PaymentStatus.PAID
    ),
    Payment(
        7,
        2,
        LocalDate.now().minusMonths(4),
        890,
        status = PaymentStatus.PAID
    ),
    Payment(
        8,
        2,
        LocalDate.now().minusMonths(5),
        890,
        status = PaymentStatus.PAID
    ),
    Payment(
        9,
        4,
        LocalDate.now().minusMonths(1),
        890,
        status = PaymentStatus.PAID
    ),
    Payment(
        10,
        3,
        LocalDate.now().minusMonths(4),
        890,
        status = PaymentStatus.PAID
    ),
    Payment(
        11,
        4,
        LocalDate.now().minusMonths(5),
        890,
        status = PaymentStatus.PAID
    ),
)