package com.adzinka.subtracker.feature.detail

import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.adzinka.subtracker.core.ui.theme.AppColors
import com.adzinka.subtracker.model.SubscriptionStatus

@Composable
fun DetailHeader(
    name: String,
    price: Int,
    currency: String,
    period: String,
    nextPaymentDate: String,
    status: SubscriptionStatus,
    iconEmoji: String,
    headerColor: Color,
    onBackClick: () -> Unit,
    onEditClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        headerColor,
                        headerColor.copy(alpha = 0.85f)
                    )
                )
            )
            .padding(bottom = 24.dp)
    ) {
        Column {
            // Top bar: back button + name + edit button
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .statusBarsPadding()
                    .padding(horizontal = 16.dp, vertical = 12.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Back Button
                IconButton(onClick = onBackClick) {
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Zpět",
                        tint = AppColors.White
                    )
                }

                Text(
                    text = name,
                    color = AppColors.White,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.weight(1f)
                )

                Box(modifier = Modifier
                    .size(30.dp)
                    .clip(CircleShape)
                    .background(AppColors.White.copy(alpha = 0.25f)),
                    contentAlignment = Alignment.Center
                ) {
                    IconButton(onClick = onEditClick) {
                        Icon(
                            imageVector = Icons.Default.Edit,
                            contentDescription = "Edit",
                            tint = AppColors.White,
                            modifier = Modifier
                                .size(16.dp)
                        )
                    }
                }

            }

            // Main info: icon + price + status
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Icon emoji
                Box(
                    modifier = Modifier
                        .size(56.dp)
                        .clip(CircleShape)
                        .background(AppColors.White.copy(alpha = 0.25f)),
                    contentAlignment = Alignment.Center
                ) {
                    Text(text = iconEmoji, fontSize = 28.sp)
                }

                Spacer(modifier = Modifier.width(16.dp))

                // Price
                Column(modifier = Modifier.weight(1f)) {
                    Row(verticalAlignment = Alignment.Bottom) {
                        Text(
                            text = "$price",
                            color = AppColors.White,
                            fontSize = 36.sp,
                            fontWeight = FontWeight.Bold,
                            lineHeight = 36.sp
                        )
                        Spacer(modifier = Modifier.width(6.dp))
                        Text(
                            text = currency,
                            color = AppColors.White,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Medium,
                            modifier = Modifier.padding(bottom = 4.dp)
                        )
                    }
                    Text(
                        text = "$price $currency / $period",
                        color = AppColors.White.copy(alpha = 0.75f),
                        fontSize = 13.sp
                    )
                }

                // Status badge
                HeaderStatusBadge(status = status)
            }

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                InfoCard(
                    label = "Příští platba",
                    value = nextPaymentDate,
                    emoji = "📅",
                    modifier = Modifier.weight(1f)
                )
                InfoCard(
                    label = "Měsíčně",
                    value = "~$price $currency",
                    emoji = "💲",
                    modifier = Modifier.weight(1f)
                )
            }
        }
    }
}

@Preview
@Composable
fun DetailHeaderPreview() {
    DetailHeader(
        name = "YouTube Premiun",
        price = 219,
        currency = "CZK",
        period = "Monthly",
        nextPaymentDate = "Tomorrow",
        status = SubscriptionStatus.SOON,
        iconEmoji = "📺",
        headerColor = Color(0xFFFF6B6B),
        onBackClick = { },
        onEditClick = { }
    )
}