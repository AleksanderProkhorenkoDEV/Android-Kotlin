package com.example.first_movile_app.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.first_movile_app.utils.FormError
import com.example.first_movile_app.utils.getMessage

@Composable
fun TextFieldCustom(
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String,
    inputLabel: @Composable () -> Unit,
    errorList: Set<FormError>?,
    modifier: Modifier = Modifier
) {
    Column {
        TextField(
            value = value,
            onValueChange = onValueChange,
            placeholder = { placeholder },
            label = inputLabel,
            modifier = modifier.fillMaxWidth()
        )
        errorList?.forEach { it -> Text(getMessage(it)) }

    }
}

@Preview
@Composable
fun TextFieldCustomPreview() {
    TextFieldCustom(
        value = "Test",
        onValueChange = {},
        placeholder = "Es un input de prueba",
        inputLabel = { InputLabel("Test label") },
        errorList = emptySet(),
        Modifier
    )
}