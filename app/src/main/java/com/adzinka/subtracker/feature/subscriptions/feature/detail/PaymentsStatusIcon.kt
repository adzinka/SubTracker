package com.adzinka.subtracker.feature.subscriptions.feature.detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.adzinka.subtracker.feature.subscriptions.model.PaymentStatus

@Composable
fun PaymentStatusIcon(status: PaymentStatus) {
    val (emoji, bgColor) = when (status) {
        PaymentStatus.PLANNED -> "🕐" to Color(0xFFEDE8FF)
        PaymentStatus.PAID    -> "✅" to Color(0xFFE8F5E9)
    }

    Box(
        modifier = Modifier
            .size(36.dp)
            .clip(CircleShape)
            .background(bgColor),
        contentAlignment = Alignment.Center
    ) {
        Text(text = emoji, fontSize = 16.sp)
    }
}

@Preview
@Composable
fun PaymentStatusIconPreview() {
    PaymentStatusIcon(PaymentStatus.PAID)
}

