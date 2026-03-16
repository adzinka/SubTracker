package com.adzinka.subtracker.feature.subscriptions.fake

import com.adzinka.subtracker.feature.subscriptions.model.Payment
import com.adzinka.subtracker.feature.subscriptions.model.PaymentStatus

val mockPayments = listOf(
    Payment(1, "7. května 2026", 890, status = PaymentStatus.PLANNED),
    Payment(2, "7. dubna 2026", 890, status = PaymentStatus.PLANNED),
    Payment(3, "7. března 2026", 890, status = PaymentStatus.PLANNED),
    Payment(4, "7. února 2026", 890, status = PaymentStatus.PAID),
    Payment(5, "7. ledna 2026", 890, status = PaymentStatus.PAID),
    Payment(6, "7. prosince 2025", 890, status = PaymentStatus.PAID),
    Payment(7, "7. listopadu 2025", 890, status = PaymentStatus.PAID),
    Payment(8, "7. října 2025", 890, status = PaymentStatus.PAID),
    Payment(9, "7. září 2025", 890, status = PaymentStatus.PAID),
    Payment(10, "7. srpna 2025", 890, status = PaymentStatus.PAID),
    Payment(11, "7. července 2025", 890, status = PaymentStatus.PAID),
)