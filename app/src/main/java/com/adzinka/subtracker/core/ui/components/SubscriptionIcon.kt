package com.adzinka.subtracker.core.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SubscriptionIcon(
    emoji: String,
    backgroundColor: Color
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .size(44.dp)
            .clip(RoundedCornerShape(20.dp))
            .background(backgroundColor)
    ) {
        Text(
            text = emoji,
            fontSize = 22.sp
        )
    }
}


@Preview
@Composable
fun SubscriptionIconPreview() {
    SubscriptionIcon(
        emoji = "📺",
        backgroundColor = Color(0xFFFF6B6B)
    )
}