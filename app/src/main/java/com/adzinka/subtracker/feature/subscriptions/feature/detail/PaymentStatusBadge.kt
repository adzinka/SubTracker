package com.adzinka.subtracker.feature.subscriptions.feature.detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.adzinka.subtracker.feature.subscriptions.model.PaymentStatus

@Composable
fun PaymentStatusBadge(status: PaymentStatus) {
    val (label, bgColor, textColor) = when (status) {
        PaymentStatus.PLANNED -> Triple("Plánováno", Color(0xFFEDE8FF), Color(0xFF6B4EFF))
        PaymentStatus.PAID    -> Triple("Zaplaceno", Color(0xFFE8F5E9), Color(0xFF4CAF50))
    }

    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(6.dp))
            .background(bgColor)
            .padding(horizontal = 8.dp, vertical = 2.dp)
    ) {
        Text(text = label, fontSize = 11.sp, fontWeight = FontWeight.SemiBold, color = textColor)
    }
}