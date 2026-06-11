package com.adzinka.subtracker.core.ui.components

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign

/**
 * Text composable optimized for displaying monetary values.
 *
 * Uses tabular figures ("tnum" OpenType feature) so all digits have equal width.
 * This prevents horizontal jitter when values change (e.g., count-up animations,
 * filter switches) and aligns numbers in vertical lists.
 *
 * Works with any TextStyle — pass `MaterialTheme.typography.displayLarge` for hero
 * amounts, `headlineMedium` for card prices, `bodyMedium` for inline figures.
 *
 * @param text monetary value already formatted as string (e.g. "1 234,56 Kč")
 * @param style base text style; tabular nums feature is added on top
 * @param color optional color override; defaults to style's color
 * @param textAlign optional alignment override
 */
@Composable
fun MonetaryText(
    text: String,
    modifier: Modifier = Modifier,
    style: TextStyle = MaterialTheme.typography.bodyLarge,
    color: Color = Color.Unspecified,
    textAlign: TextAlign? = null
) {
    Text(
        text = text,
        modifier = modifier,
        color = color,
        textAlign = textAlign,
        style = style.copy(
            fontFeatureSettings = "tnum, kern"
        )
    )
}