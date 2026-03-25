package com.adzinka.subtracker.fake

import androidx.compose.ui.graphics.Color
import com.adzinka.subtracker.model.Category
import com.adzinka.subtracker.model.Subscription
import com.adzinka.subtracker.model.SubscriptionStatus

val mockSubscriptions = listOf(
    Subscription(
        1,
        "YouTube Premium",
        Category.STREAMING,
        "Tomorrow",
        219,
        status = SubscriptionStatus.SOON,
    ),
    Subscription(
        2,
        "Fitness Zone",
        Category.FITNESS,
        "7. 3.",
        890,
        status = SubscriptionStatus.SOON,
    ),
    Subscription(
        3,
        "Adobe Creative Cloud",
        Category.PRODUCTIVITY,
        "8. 3.",
        1199,
        status = SubscriptionStatus.SOON,
    ),
    Subscription(
        4,
        "Netflix",
        Category.STREAMING,
        "12. 3.",
        249,
        status = SubscriptionStatus.SOON,
    ),
    Subscription(
        5,
        "iCloud+",
        Category.CLOUD,
        "15. 3.",
        49,
        status = SubscriptionStatus.ACTIVE,
    ),
    Subscription(
        6,
        "Spotify",
        Category.MUSIC,
        "22. 3.",
        149,
        status = SubscriptionStatus.ACTIVE,
    ),
    Subscription(
        7,
        "O2 TV",
        Category.STREAMING,
        "25. 3.",
        199,
        status = SubscriptionStatus.PAUSED,
    )
)