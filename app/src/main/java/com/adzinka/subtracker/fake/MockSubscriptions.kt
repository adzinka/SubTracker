package com.adzinka.subtracker.fake

import com.adzinka.subtracker.model.Category
import com.adzinka.subtracker.model.Subscription
import com.adzinka.subtracker.model.SubscriptionStatus
import java.time.LocalDate

val mockSubscriptions = listOf(
    Subscription(
        1,
        "YouTube Premium",
        Category.STREAMING,
        LocalDate.now().plusDays(1),
        219,
        status = SubscriptionStatus.ACTIVE,
    ),
    Subscription(
        2,
        "Fitness Zone",
        Category.FITNESS,
        LocalDate.now().plusDays(3),
        890,
        status = SubscriptionStatus.ACTIVE,
    ),
    Subscription(
        3,
        "Adobe Creative Cloud",
        Category.PRODUCTIVITY,
        LocalDate.now().plusDays(5),
        1199,
        status = SubscriptionStatus.ACTIVE,
    ),
    Subscription(
        4,
        "Netflix",
        Category.STREAMING,
        LocalDate.now().plusDays(7),
        249,
        status = SubscriptionStatus.ACTIVE,
    ),
    Subscription(
        5,
        "iCloud+",
        Category.CLOUD,
        LocalDate.now().plusDays(10),
        49,
        status = SubscriptionStatus.ACTIVE,
    ),
    Subscription(
        6,
        "Spotify",
        Category.MUSIC,
        LocalDate.now().plusDays(15),
        149,
        status = SubscriptionStatus.ACTIVE,
    ),
    Subscription(
        7,
        "O2 TV",
        Category.STREAMING,
        LocalDate.now().plusDays(25),
        199,
        status = SubscriptionStatus.PAUSED,
    )
)