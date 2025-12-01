package com.example.first_movile_app.ui.components

import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.first_movile_app.R

@Composable
fun CheckButton(
    isChecked: Boolean = false,
    callbackChecked: (Boolean) -> Unit,
){
    Checkbox(
        checked = isChecked,
        onCheckedChange = callbackChecked,
        colors = CheckboxDefaults.colors(
            checkedColor = colorResource(R.color.accent_success),
            uncheckedColor = colorResource(R.color.text_secondary),
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