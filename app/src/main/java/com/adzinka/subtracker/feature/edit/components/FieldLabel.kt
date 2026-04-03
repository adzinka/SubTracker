package com.adzinka.subtracker.feature.edit.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.adzinka.subtracker.core.ui.theme.AppColors

@Composable
fun FieldLabel(text: String) {
    Text(text = text, fontSize = 13.sp, fontWeight = FontWeight.Medium, color = AppColors.TextSecondary)
}