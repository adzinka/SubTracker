package com.adzinka.subtracker.feature.subscriptions.core.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun FilterRow(
    selectedFilter: String,
    soonCount: Int,
    onFilterSelected: (String) -> Unit,
) {
    val filters = listOf("All", "Active", "Paused", "Soon")

    Row(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    ) {
        filters.forEach { filter ->
            FilterChip(
                label = filter,
                badge = if (filter == "Soon") soonCount else null,
                isSelected = filter == selectedFilter,
                onClick = { onFilterSelected(filter) }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FilterRowPreview() {
    FilterRow(
        selectedFilter = "All",
        soonCount = 4,
        onFilterSelected = { },
    )
}