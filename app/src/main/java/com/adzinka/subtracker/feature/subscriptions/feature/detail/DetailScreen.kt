package com.adzinka.subtracker.feature.subscriptions.feature.detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.adzinka.subtracker.feature.subscriptions.fake.mockPayments
import com.adzinka.subtracker.feature.subscriptions.model.Payment
import com.adzinka.subtracker.feature.subscriptions.model.SubscriptionStatus

@Composable
fun DetailScreen(
    name: String = "Fitness Zone",
    category: String = "Fitness",
    price: Int = 890,
    currency: String = "CZK",
    period: String = "měsíc",
    nextPaymentDate: String = "7. března 2026",
    status: SubscriptionStatus = SubscriptionStatus.SOON,
    notes: String? = "All-inclusive membership",
    iconEmoji: String = "🏋️",
    headerColor: Color = Color(0xFFFF8C55),
    payments: List<Payment> = mockPayments,
    onBackClick: () -> Unit = {},
    onEditClick: () -> Unit = {}
) {

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF5F5F5))
    ) {

        item {
            DetailHeader(
                name = name,
                price = price,
                currency = currency,
                period = period,
                nextPaymentDate = nextPaymentDate,
                status = status,
                iconEmoji = iconEmoji,
                headerColor = headerColor,
                onBackClick = onBackClick,
                onEditClick = onEditClick
            )
        }

        item {
            ActionButtons(
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 16.dp)
            )
        }

        if (!notes.isNullOrEmpty()) {
            item {
                NotesCard(
                    notes = notes,
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 4.dp)
                )
            }
        }

        item {
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .background(Color.White)
                    .padding(horizontal = 16.dp, vertical = 12.dp)
            ) {
                PaymentsHeader(count = payments.size)

                Spacer(modifier = Modifier.height(8.dp))

                payments.forEach { payment ->
                    PaymentRow(
                        payment = payment,
                        modifier = Modifier.padding(vertical = 4.dp)
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DetailScreenPreview() {
    MaterialTheme {
        DetailScreen()
    }
}
