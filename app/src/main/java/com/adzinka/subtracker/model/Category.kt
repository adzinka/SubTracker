package com.adzinka.subtracker.model

enum class Category(
    val categoryName: String,
    val iconEmoji: String,
    val iconColor: Long
) {
    STREAMING("Streaming", "📺", 0xFFFF6B6B),
    FITNESS("Fitness", "🏋️", 0xFFFFB347),
    PRODUCTIVITY("Produktivita", "💼", 0xFF6B9EFF),
    CLOUD("Cloud", "☁️", 0xFF87CEEB),
    MUSIC("Hudba", "🎵", 0xFF1DB954),
    GAMING("Gaming", "🎮", 0xFF9B7FFF),
    OTHER("Ostatní", "📦", 0xFF888888)
}