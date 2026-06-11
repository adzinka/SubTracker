package com.adzinka.subtracker.core.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.adzinka.subtracker.core.ui.theme.color
import com.adzinka.subtracker.core.ui.theme.iconRes
import com.adzinka.subtracker.model.Category

@Composable
fun CategoryIcon(
    category: Category,
    modifier: Modifier = Modifier,
    size: Dp = 40.dp
) {
    Box(
        modifier = modifier
            .size(size)
            .background(category.color, MaterialTheme.shapes.medium),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            painter = painterResource(category.iconRes),
            contentDescription = category.displayName,
            tint = Color.White,
            modifier = Modifier.size(size * 0.5f)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun CategoryIconPreview() {
    Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
        Category.entries.forEach { CategoryIcon(it) }
    }
}