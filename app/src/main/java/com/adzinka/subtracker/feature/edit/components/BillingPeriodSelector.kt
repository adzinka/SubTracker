package com.adzinka.subtracker.feature.edit.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.SegmentedButton
import androidx.compose.material3.SegmentedButtonDefaults
import androidx.compose.material3.SingleChoiceSegmentedButtonRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.adzinka.subtracker.model.BillingPeriod

@Composable
fun BillingPeriodSelector(selected: BillingPeriod, onSelected: (BillingPeriod) -> Unit) {
    Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
        FieldLabel("Frekvence")
        SingleChoiceSegmentedButtonRow(modifier = Modifier.fillMaxWidth()) {
            BillingPeriod.entries.forEachIndexed { index, period ->
                SegmentedButton(
                    selected = period == selected,
                    onClick = { onSelected(period) },
                    shape = SegmentedButtonDefaults.itemShape(index, BillingPeriod.entries.size),
                    label = { Text(period.label) }
                )
            }
        }
    }
}

@Preview
@Composable
fun BillingPeriodSelectorPreview() {
    BillingPeriodSelector(BillingPeriod.MONTHLY, onSelected = {})
}