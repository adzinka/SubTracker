package com.adzinka.subtracker.core.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import com.adzinka.subtracker.core.ui.theme.AppColors.Accent500
import com.adzinka.subtracker.core.ui.theme.AppColors.BgCard
import com.adzinka.subtracker.core.ui.theme.AppColors.BgPrimary
import com.adzinka.subtracker.core.ui.theme.AppColors.BgSubtle
import com.adzinka.subtracker.core.ui.theme.AppColors.BorderSubtle
import com.adzinka.subtracker.core.ui.theme.AppColors.Brand900
import com.adzinka.subtracker.core.ui.theme.AppColors.Danger
import com.adzinka.subtracker.core.ui.theme.AppColors.TextPrimary
import com.adzinka.subtracker.core.ui.theme.AppColors.TextSecondary

private val DarkColorScheme = darkColorScheme(
    primary = Purple80,
    secondary = PurpleGrey80,
    tertiary = Pink80
)

private val LightColorScheme = lightColorScheme(
    primary = Brand900,
    onPrimary = Color.White,
    secondary = Accent500,
    onSecondary = Color.White,
    background = BgPrimary,
    onBackground = TextPrimary,
    surface = BgCard,
    onSurface = TextPrimary,
    surfaceVariant = BgSubtle,
    onSurfaceVariant = TextSecondary,
    error = Danger,
    onError = Color.White,
    outline = BorderSubtle
)

@Composable
fun SubTrackerTheme(
    // Dark mode will be added in the next version (the v2 design is light-only).
    @Suppress("UNUSED_PARAMETER")
    darkTheme: Boolean = isSystemInDarkTheme(),
//    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
//    val colorScheme = when {
//        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
//            val context = LocalContext.current
//            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
//        }
//
//        darkTheme -> DarkColorScheme
//        else -> LightColorScheme
//    }

    MaterialTheme(
        colorScheme = LightColorScheme,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}