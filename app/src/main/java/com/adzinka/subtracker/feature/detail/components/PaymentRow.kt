package com.adzinka.subtracker.feature.detail.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.adzinka.subtracker.fake.mockPayments
import com.adzinka.subtracker.model.Payment

@Composable
fun PaymentRow(payment: Payment, modifier: Modifier = Modifier) {
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {

        PaymentStatusIcon(status = payment.status)

        Spacer(modifier = Modifier.width(12.dp))

        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = payment.date,
                fontSize = 14.sp,
                fontWeight = FontWeight.Medium,
                color = Color(0xFF1A1A2E)
            )
            Spacer(modifier = Modifier.height(2.dp))
            PaymentStatusBadge(status = payment.status)
        }

        Text(
            text = "${payment.amount} ${payment.currency}",
            fontSize = 15.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF1A1A2E)
        )
    }
}

@Preview
@Composable
fun PaymentRowPreview(modifier: Modifier = Modifier) {
    PaymentRow(
        mockPayments[1]
    )
}