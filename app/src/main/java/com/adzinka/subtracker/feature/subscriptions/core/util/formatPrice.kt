package com.adzinka.subtracker.feature.subscriptions.core.util

fun formatPrice(price: Int): String {
    return if (price >= 1000) {
        "${price / 1000} ${price % 1000}".trimEnd()
    } else {
        price.toString()
    }
}