package com.adzinka.subtracker.feature.edit.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.adzinka.subtracker.core.ui.formatFull
import java.time.LocalDate

@Composable
fun DateField(
    value: LocalDate?,
    onValueChange: (LocalDate) -> Unit
) {
    var showDialog by remember { mutableStateOf(false) }

    Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
        FieldLabel("Datum příštího stržení *")

        OutlinedTextField(
            value = value?.formatFull() ?: "",
            onValueChange = { },
            readOnly = true,
            enabled = false,
            placeholder = { Text("Vyberte datum") },
            singleLine = true,
            shape = RoundedCornerShape(12.dp),
            colors = OutlinedTextFieldDefaults.colors(
                disabledTextColor = MaterialTheme.colorScheme.onSurface,
                disabledBorderColor = MaterialTheme.colorScheme.outline,
                disabledTrailingIconColor = MaterialTheme.colorScheme.onSurfaceVariant,
                disabledPlaceholderColor = MaterialTheme.colorScheme.onSurfaceVariant
            ),
            trailingIcon = {
                Icon(Icons.Default.DateRange, contentDescription = null)
            },
            modifier = Modifier
                .fillMaxWidth()
                .clickable { showDialog = true }
        )
    }

    if (showDialog) {
        DatePickerModal(
            initialDate = value,
            onDateSelected = onValueChange,
            onDismiss = { showDialog = false }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DateFieldPreview() {
    DateField(value = LocalDate.now(), onValueChange = {})
}