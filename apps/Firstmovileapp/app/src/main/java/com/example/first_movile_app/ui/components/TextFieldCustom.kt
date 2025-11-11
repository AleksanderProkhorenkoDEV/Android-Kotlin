package com.example.first_movile_app.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun TextFieldCustom(
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String,
    inputLabel: @Composable () -> Unit,
    modifier: Modifier = Modifier
) {
    TextField(
        value = value,
        onValueChange = onValueChange,
        placeholder = { placeholder },
        label = inputLabel,
        modifier = modifier.fillMaxWidth()
    )
}

@Preview
@Composable
fun TextFieldCustomPreview() {
    TextFieldCustom(
        value = "Test",
        onValueChange = {},
        placeholder = "Es un input de prueba",
        inputLabel = { InputLabel("Test label") },
        Modifier
    )
}