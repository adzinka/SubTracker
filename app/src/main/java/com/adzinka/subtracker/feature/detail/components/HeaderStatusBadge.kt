package com.adzinka.subtracker.feature.detail.components

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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.adzinka.subtracker.model.SubscriptionStatus
import com.adzinka.subtracker.model.SubscriptionStatus.ACTIVE
import com.adzinka.subtracker.model.SubscriptionStatus.PAUSED
import com.adzinka.subtracker.model.SubscriptionStatus.SOON

@Composable
fun HeaderStatusBadge(status: SubscriptionStatus) {
    val (label, bgColor, textColor) = when (status) {
        ACTIVE -> Triple("Aktivní", Color.White.copy(alpha = 0.25f), Color.White)
        SOON -> Triple("Brzy", Color.White.copy(alpha = 0.25f), Color.White)
        PAUSED -> Triple("Pozastaveno", Color(0xFFFFF3E0), Color(0xFFFF9800))
    }

    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(20.dp))
            .background(bgColor)
            .padding(horizontal = 12.dp, vertical = 6.dp)
    ) {
        Text(text = label, color = textColor, fontSize = 13.sp, fontWeight = FontWeight.Medium)
    }
}

@Preview
@Composable
fun HeaderStatusBadgePreview() {
    HeaderStatusBadge(SubscriptionStatus.SOON)
}