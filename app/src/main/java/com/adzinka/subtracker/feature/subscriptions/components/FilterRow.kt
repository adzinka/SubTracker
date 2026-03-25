package com.adzinka.subtracker.feature.subscriptions.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.adzinka.subtracker.feature.subscriptions.core.ui.components.FilterChip
import com.adzinka.subtracker.model.FilterStatus

@Composable
fun FilterRow(
    selectedFilter: FilterStatus,
    soonCount: Int,
    onFilterSelected: (FilterStatus) -> Unit,
) {

    Row(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    ) {
        FilterStatus.entries.forEach { filter ->
            FilterChip(
                label = filter.name,
                badge = if (filter.name == "Soon") soonCount else null,
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
        selectedFilter = FilterStatus.ALL,
        soonCount = 4,
        onFilterSelected = { },
    )
}