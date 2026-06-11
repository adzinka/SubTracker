package com.adzinka.subtracker.core.ui.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Shapes
import androidx.compose.ui.unit.dp

val Shapes = Shapes(
    extraSmall = RoundedCornerShape(6.dp),  // badges, chips
    small = RoundedCornerShape(8.dp),       // small buttons, tags
    medium = RoundedCornerShape(12.dp),     // cards, list items
    large = RoundedCornerShape(20.dp),      // hero blocks, dialogs
    extraLarge = RoundedCornerShape(24.dp)  // bottom sheets, large containers
)