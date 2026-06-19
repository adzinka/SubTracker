package com.adzinka.subtracker.core.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.pluralStringResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.adzinka.subtracker.R
import com.adzinka.subtracker.core.ui.theme.AppColors.BadgeYellow
import com.adzinka.subtracker.core.ui.theme.AppColors.BgSubtle
import com.adzinka.subtracker.core.ui.theme.AppColors.CategoryNews
import com.adzinka.subtracker.core.ui.theme.AppColors.Danger
import com.adzinka.subtracker.core.ui.theme.AppColors.TextPrimary
import com.adzinka.subtracker.core.ui.theme.AppColors.TextTertiary
import com.adzinka.subtracker.core.ui.theme.AppColors.Warning

sealed interface UrgencyState {
    data object Tomorrow : UrgencyState
    data object Soon : UrgencyState
    data class Days(val count: Int) : UrgencyState
    data object Paused : UrgencyState
}

@Composable
fun UrgencyBadge(
    state: UrgencyState,
    modifier: Modifier = Modifier
) {
    val (backgroundColor, contentColor, text) = when (state) {
        UrgencyState.Tomorrow -> Triple(
            Danger,
            Color.White,
            stringResource(R.string.badge_tomorrow)
        )

        UrgencyState.Soon -> Triple(
            Warning,
            TextPrimary,
            stringResource(R.string.badge_soon)
        )

        is UrgencyState.Days -> Triple(
            BadgeYellow,
            TextPrimary,
            pluralStringResource(R.plurals.days_until_payment, state.count, state.count)
        )

        UrgencyState.Paused -> Triple(
            BgSubtle,
            TextTertiary,
            stringResource(R.string.badge_paused)
        )
    }

    Box(
        modifier = modifier
            .background(backgroundColor, MaterialTheme.shapes.extraSmall)
            .padding(horizontal = 8.dp, vertical = 3.dp)
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.labelSmall.copy(
                letterSpacing = 0.sp
            ),
            color = contentColor
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun UrgencyBadgePreview() {
    Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
        UrgencyBadge(UrgencyState.Tomorrow)
        UrgencyBadge(UrgencyState.Soon)
        UrgencyBadge(UrgencyState.Days(3))
        UrgencyBadge(UrgencyState.Paused)
    }
}