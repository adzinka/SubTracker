package com.adzinka.subtracker.feature.subscriptions.components

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
import com.adzinka.subtracker.core.ui.theme.AppColors
import com.adzinka.subtracker.model.SubscriptionStatus

@Composable
fun StatusBadge(status: SubscriptionStatus) {
    val (bgColor, textColor, label) = when (status) {
        SubscriptionStatus.SOON -> Triple(AppColors.BadgeSoon, AppColors.BadgeSoonText, "Soon")
        SubscriptionStatus.PAUSED -> Triple(AppColors.BadgePaused, AppColors.BadgePausedText, "Pause")
        SubscriptionStatus.ACTIVE -> Triple(Color.Transparent, Color.Transparent, "")
    }

    if (label.isNotEmpty()) {
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(12.dp))
                .background(bgColor)
                .padding(horizontal = 6.dp, vertical = 2.dp)
        ) {
            Text(
                text = label,
                fontSize = 10.sp,
                fontWeight = FontWeight.SemiBold,
                color = textColor
            )
        }
    }
}

@Preview
@Composable
fun StatusBadgePreview() {
    StatusBadge(
        SubscriptionStatus.PAUSED
    )
}