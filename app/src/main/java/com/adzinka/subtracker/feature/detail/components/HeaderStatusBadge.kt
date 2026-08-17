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

private data class StatusStyle(
    val label: String,
    val background: Color,
    val content: Color
)
@Composable
fun HeaderStatusBadge(status: SubscriptionStatus) {
    val style = when (status) {
        SubscriptionStatus.ACTIVE -> StatusStyle(
            label = "Aktivní",
            background = Color.White.copy(alpha = 0.25f),
            content = Color.White
        )
        SubscriptionStatus.PAUSED -> StatusStyle(
            label = "Pozastaveno",
            background = Color(0xFFFFF3E0),
            content = Color(0xFFFF9800)
        )
    }

    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(20.dp))
            .background(style.background)
            .padding(horizontal = 12.dp, vertical = 6.dp)
    ) {
        Text(text = style.label, color = style.content, fontSize = 13.sp, fontWeight = FontWeight.Medium)
    }
}

@Preview
@Composable
fun HeaderStatusBadgePreview() {
    HeaderStatusBadge(SubscriptionStatus.ACTIVE)
}