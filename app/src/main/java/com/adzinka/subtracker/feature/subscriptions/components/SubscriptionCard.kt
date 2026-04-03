package com.adzinka.subtracker.feature.subscriptions.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.adzinka.subtracker.core.ui.theme.AppColors
import com.adzinka.subtracker.core.util.formatPrice
import com.adzinka.subtracker.fake.mockSubscriptions
import com.adzinka.subtracker.feature.subscriptions.SubscriptionsItemUiState
import com.adzinka.subtracker.model.SubscriptionStatus

@Composable
fun SubscriptionCard(
    subscription: SubscriptionsItemUiState,
    onClick: () -> Unit
) {
    Card(
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = AppColors.CardBackground),
        elevation = CardDefaults.cardElevation(defaultElevation = 1.dp),
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick),
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            SubscriptionIcon(
                emoji = subscription.category.iconEmoji,
                backgroundColor = Color(subscription.category.iconColor).copy(alpha = 0.15f)
            )

            Spacer(modifier = Modifier.width(12.dp))

            Column(
                modifier = Modifier.weight(1f)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(6.dp)
                ) {
                    Text(
                        text = subscription.name,
                        fontSize = 15.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = AppColors.TextPrimary,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        modifier = Modifier.weight(1f)
                    )

                    if (subscription.status != SubscriptionStatus.ACTIVE) {
                        StatusBadge(status = subscription.status)
                    }
                }

                Spacer(modifier = Modifier.height(2.dp))

                Text(
                    text = "${subscription.category}  ·  ${subscription.nextPaymentDate}",
                    fontSize = 12.sp,
                    color = AppColors.TextSecondary
                )
            }

            Spacer(modifier = Modifier.width(8.dp))

            Column(horizontalAlignment = Alignment.End) {
                Text(
                    text = "${formatPrice(subscription.price)} ${subscription.currency}",
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold,
                    color = AppColors.TextPrimary
                )
                Text(
                    text = subscription.billingPeriod.label,
                    fontSize = 11.sp,
                    color = AppColors.TextSecondary
                )
            }

        }
    }
}

//@Preview
//@Composable
//fun SubscriptionCardPreview() {
//    MaterialTheme {
//        Box(modifier = Modifier.padding(16.dp)) {
//            SubscriptionCard(
//                subscription = mockSubscriptions[2]
//            )
//        }
//    }
//}
