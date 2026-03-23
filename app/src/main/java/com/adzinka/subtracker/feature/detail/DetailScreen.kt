package com.adzinka.subtracker.feature.detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.adzinka.subtracker.fake.mockPayments
import com.adzinka.subtracker.fake.mockSubscriptions
import com.adzinka.subtracker.feature.detail.components.ActionButtons
import com.adzinka.subtracker.feature.detail.components.DetailHeader
import com.adzinka.subtracker.feature.detail.components.NotesCard
import com.adzinka.subtracker.feature.detail.components.PaymentRow
import com.adzinka.subtracker.feature.detail.components.PaymentsHeader
import com.adzinka.subtracker.model.Payment
import com.adzinka.subtracker.model.Subscription

@Composable
fun DetailScreen(
    subscriptionId: Int,
//    name: String = "Fitness Zone",
//    category: String = "Fitness",
//    price: Int = 890,
//    currency: String = "CZK",
//    period: String = "měsíc",
//    nextPaymentDate: String = "7. března 2026",
//    status: SubscriptionStatus = SubscriptionStatus.SOON,
//    notes: String? = "All-inclusive membership",
//    iconEmoji: String = "🏋️",
//    headerColor: Color = Color(0xFFFF8C55),
//    payments: List<Payment> = mockPayments,
    onBackClick: () -> Unit,
    onEditClick: () -> Unit,
    viewModel: com.adzinka.subtracker.feature.detail.DetailViewModel = viewModel(
        factory = _root_ide_package_.com.adzinka.subtracker.feature.detail.DetailViewModelFactory(
            subscriptionId
        )
    )
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    when (val state = uiState) {
        is DetailUiState.Loading -> { /* спиннер */ }
        is DetailUiState.Success -> {
            DetailContent(
                subscription = state.subscription,
                payments = state.payments,
                onBackClick = onBackClick,
                onEditClick = onEditClick,
                onPayClick = viewModel::onPayClick,
                onPauseClick = viewModel::onPauseClick
            )
        }
        is DetailUiState.Error -> { /* ошибка */ }
    }

}

@Composable
private fun DetailContent(
    subscription: Subscription,
    payments: List<Payment>,
    onBackClick: () -> Unit,
    onEditClick: () -> Unit,
    onPayClick: () -> Unit,
    onPauseClick: () -> Unit
) {

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF5F5F5))
    ) {

        item {
            DetailHeader(
                name = subscription.name,
                price = subscription.price,
                currency = subscription.currency,
                period = subscription.period,
                nextPaymentDate = subscription.nextPaymentDate,
                status = subscription.status,
                iconEmoji = subscription.iconEmoji,
                headerColor = subscription.iconColor,
                onBackClick = onBackClick,
                onEditClick = onEditClick
            )
        }

        item {
            ActionButtons(
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 16.dp)
            )
        }

        if (!subscription.notes.isNullOrEmpty()) {
            item {
                NotesCard(
                    notes = subscription.notes,
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
        DetailContent(
            subscription = mockSubscriptions[1],
            payments = mockPayments,
            onBackClick = {},
            onEditClick = {},
            onPayClick = {},
            onPauseClick = {}
        )
    }
}
