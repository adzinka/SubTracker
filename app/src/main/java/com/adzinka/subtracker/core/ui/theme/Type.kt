package com.adzinka.subtracker.core.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.adzinka.subtracker.R

val InterFont = FontFamily(
    Font(R.font.inter_light, FontWeight.Light),
    Font(R.font.inter_regular, FontWeight.Normal),
    Font(R.font.inter_medium, FontWeight.Medium),
    Font(R.font.inter_semibold, FontWeight.SemiBold),
    Font(R.font.inter_bold, FontWeight.Bold)
)

// Set of Material typography styles to start with
val Typography = Typography(
    // region Display — large monetary values, hero numbers
    displayLarge = TextStyle(
        fontFamily = InterFont,
        fontSize = 64.sp,
        fontWeight = FontWeight.Light,
        letterSpacing = (-1.28).sp, // -2%
        lineHeight = 72.sp
    ),
    displayMedium = TextStyle(
        fontFamily = InterFont,
        fontSize = 48.sp,
        fontWeight = FontWeight.Light,
        letterSpacing = (-0.72).sp,
        lineHeight = 56.sp
    ),
    displaySmall = TextStyle(
        fontFamily = InterFont,
        fontSize = 32.sp,
        fontWeight = FontWeight.Normal,
        lineHeight = 40.sp
    ),
    // endregion

    // region Headline — section titles, screen headers
    headlineLarge = TextStyle(
        fontFamily = InterFont,
        fontSize = 24.sp,
        fontWeight = FontWeight.SemiBold,
        lineHeight = 32.sp
    ),
    headlineMedium = TextStyle(
        fontFamily = InterFont,
        fontSize = 18.sp,
        fontWeight = FontWeight.SemiBold,
        lineHeight = 24.sp
    ),
    headlineSmall = TextStyle(
        fontFamily = InterFont,
        fontSize = 14.sp,
        fontWeight = FontWeight.SemiBold,
        lineHeight = 20.sp
    ),
    // endregion

    // region Body — main content text
    bodyLarge = TextStyle(
        fontFamily = InterFont,
        fontSize = 16.sp,
        fontWeight = FontWeight.Normal,
        lineHeight = 24.sp
    ),
    bodyMedium = TextStyle(
        fontFamily = InterFont,
        fontSize = 14.sp,
        fontWeight = FontWeight.Normal,
        lineHeight = 20.sp
    ),
    bodySmall = TextStyle(
        fontFamily = InterFont,
        fontSize = 12.sp,
        fontWeight = FontWeight.Normal,
        lineHeight = 16.sp
    ),
    // endregion

    // region Label — uppercase tags, badges, eyebrow text
    labelLarge = TextStyle(
        fontFamily = InterFont,
        fontSize = 12.sp,
        fontWeight = FontWeight.Medium,
        letterSpacing = 0.96.sp, // 8%
        lineHeight = 16.sp
    ),
    labelMedium = TextStyle(
        fontFamily = InterFont,
        fontSize = 10.sp,
        fontWeight = FontWeight.Medium,
        letterSpacing = 1.sp, // 10%
        lineHeight = 14.sp
    ),
    labelSmall = TextStyle(
        fontFamily = InterFont,
        fontSize = 9.sp,
        fontWeight = FontWeight.SemiBold,
        letterSpacing = 1.08.sp, // 12%
        lineHeight = 12.sp
    )
    // endregion
)