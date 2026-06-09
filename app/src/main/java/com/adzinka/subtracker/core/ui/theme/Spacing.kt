package com.adzinka.subtracker.core.ui.theme

import androidx.compose.ui.unit.dp

/**
 * Spacing scale based on a 4dp grid.
 *
 * Use these constants instead of hardcoded dp values to keep visual rhythm
 * consistent across the app. Each step roughly doubles or follows the 4dp grid.
 */
object Spacing {
    /** 4dp — tightest spacing, between icon and adjacent text */
    val xxs = 4.dp

    /** 8dp — between related elements inside a component */
    val xs = 8.dp

    /** 12dp — small gap, e.g. between rows in a list item */
    val sm = 12.dp

    /** 16dp — default padding, most common spacing */
    val md = 16.dp

    /** 20dp — medium gap, e.g. between sections inside a card */
    val lg = 20.dp

    /** 24dp — large gap, between major sections on a screen */
    val xl = 24.dp

    /** 32dp — spacing between distinct screen regions */
    val xxl = 32.dp

    /** 40dp — large screen padding, hero blocks */
    val xxxl = 40.dp

    /** 48dp — extra large, top of screens / above primary CTA */
    val huge = 48.dp
}