package com.adzinka.subtracker.feature.detail.components

import android.R.attr.onClick
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ActionButtons(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {

        OutlinedButton(
            onClick = { /* TODO */ },
            modifier = Modifier.weight(1f),
            shape = RoundedCornerShape(12.dp),
            colors = ButtonDefaults.outlinedButtonColors(
                containerColor = Color(0xFFE8F5E9),
                contentColor = Color(0xFF4CAF50)
            ),
            border = BorderStroke(1.dp, Color(0xFF4CAF50).copy(alpha = 0.5f))
        ) {
            Text("✅  Zaplatit", fontWeight = FontWeight.SemiBold)
        }

        OutlinedButton(
            onClick = { /* TODO */ },
            modifier = Modifier.weight(1f),
            shape = RoundedCornerShape(12.dp),
            colors = ButtonDefaults.outlinedButtonColors(
                containerColor = Color(0xFFFFF3E0),
                contentColor = Color(0xFFFF9800)
            ),
            border = BorderStroke(1.dp, Color(0xFFFF9800).copy(alpha = 0.5f))
        ) {
            Text("⏸  Pozastavit", fontWeight = FontWeight.SemiBold)
        }
    }
}

@Preview
@Composable
fun ActionButtonsPreview() {
    ActionButtons()
}