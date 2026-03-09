package com.adzinka.subtracker.feature.subscriptions.fake

import androidx.compose.ui.graphics.Color
import com.adzinka.subtracker.feature.subscriptions.model.Subscription
import com.adzinka.subtracker.feature.subscriptions.model.SubscriptionStatus

val mockSubscriptions = listOf(
    Subscription(
        1,
        "YouTube Premium",
        "Streaming",
        "Tomorrow",
        219,
        status = SubscriptionStatus.SOON,
        iconEmoji = "📺",
        iconColor = Color(0xFFFF6B6B)
    ),
    Subscription(
        2,
        "Fitness Zone",
        "Fitness",
        "7. 3.",
        890,
        status = SubscriptionStatus.SOON,
        iconEmoji = "🏋️",
        iconColor = Color(0xFFFFB347)
    ),
    Subscription(
        3,
        "Adobe Creative Cloud",
        "Productivity",
        "8. 3.",
        1199,
        status = SubscriptionStatus.SOON,
        iconEmoji = "💼",
        iconColor = Color(0xFF6B9EFF)
    ),
    Subscription(
        4,
        "Netflix",
        "Streaming",
        "12. 3.",
        249,
        status = SubscriptionStatus.SOON,
        iconEmoji = "🎬",
        iconColor = Color(0xFFFF6B6B)
    ),
    Subscription(
        5,
        "iCloud+",
        "Cloud",
        "15. 3.",
        49,
        status = SubscriptionStatus.ACTIVE,
        iconEmoji = "☁️",
        iconColor = Color(0xFF87CEEB)
    ),
    Subscription(
        6,
        "Spotify",
        "Music",
        "22. 3.",
        149,
        status = SubscriptionStatus.ACTIVE,
        iconEmoji = "🎵",
        iconColor = Color(0xFF1DB954)
    ),
    Subscription(
        7,
        "O2 TV",
        "Streaming",
        "25. 3.",
        199,
        status = SubscriptionStatus.PAUSED,
        iconEmoji = "📡",
        iconColor = Color(0xFFAA88FF)
    )
)