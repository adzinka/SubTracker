package com.adzinka.subtracker.fake

import com.adzinka.subtracker.model.Payment
import com.adzinka.subtracker.model.PaymentStatus

val mockPayments = listOf(
    Payment(1, 1, "7. května 2026", 890, status = PaymentStatus.PLANNED),
    Payment(2, 1,"7. dubna 2026", 890, status = PaymentStatus.PLANNED),
    Payment(3, 1, "7. března 2026", 890, status = PaymentStatus.PLANNED),
    Payment(4, 2, "7. února 2026", 890, status = PaymentStatus.PAID),
    Payment(5, 2, "7. ledna 2026", 890, status = PaymentStatus.PAID),
    Payment(6, 2, "7. prosince 2025", 890, status = PaymentStatus.PAID),
    Payment(7, 2, "7. listopadu 2025", 890, status = PaymentStatus.PAID),
    Payment(8, 2, "7. října 2025", 890, status = PaymentStatus.PAID),
    Payment(9, 4, "7. září 2025", 890, status = PaymentStatus.PAID),
    Payment(10, 3, "7. srpna 2025", 890, status = PaymentStatus.PAID),
    Payment(11, 4, "7. července 2025", 890, status = PaymentStatus.PAID),
)