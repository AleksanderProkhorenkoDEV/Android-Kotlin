package com.example.first_movile_app.components

import androidx.compose.material3.Checkbox
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun CheckButton(
    isChecked: Boolean = false,
    callbackChecked: (Boolean) -> Unit,
){
    Checkbox(
        checked = isChecked,
        onCheckedChange = callbackChecked
    )
}

@Preview(showBackground = true)
@Composable
fun CheckButtonPreview(){
    CheckButton(
        isChecked =  false,
        callbackChecked = { },
    )
}