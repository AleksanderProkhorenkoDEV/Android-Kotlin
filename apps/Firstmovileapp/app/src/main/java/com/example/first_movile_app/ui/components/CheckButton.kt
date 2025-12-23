package com.example.first_movile_app.ui.components

import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun CheckButton(
    isChecked: Boolean = false,
    callbackChecked: (Boolean) -> Unit,
){
    Checkbox(
        checked = isChecked,
        onCheckedChange = callbackChecked,
        colors = CheckboxDefaults.colors(
            checkedColor = MaterialTheme.colorScheme.tertiary,
            uncheckedColor = MaterialTheme.colorScheme.onSurface,
        )
    )
}

@Preview(showBackground = false)
@Composable
fun CheckButtonPreview(){
    CheckButton(
        isChecked =  true,
        callbackChecked = { },
    )
}