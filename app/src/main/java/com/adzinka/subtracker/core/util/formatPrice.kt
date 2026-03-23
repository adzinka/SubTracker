package com.adzinka.subtracker.core.util

fun formatPrice(price: Int): String {
    return if (price >= 1000) {
        "${price / 1000} ${price % 1000}".trimEnd()
    } else {
        price.toString()
    }
}