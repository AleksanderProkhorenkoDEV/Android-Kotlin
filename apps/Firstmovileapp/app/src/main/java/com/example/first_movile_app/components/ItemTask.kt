package com.example.first_movile_app.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ItemTask(
    text: String,
    isChecked: Boolean,
    callbackChecked: (Boolean) -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .padding(8.dp)
            .fillMaxWidth(1f)
    ) {
        Text(text = text)
        CheckButton(isChecked, callbackChecked = callbackChecked)
    }
}

@Preview(showBackground = true)
@Composable
fun ItemTaskPreview(
    modifier: Modifier = Modifier
) {
    ItemTask("Test task", true, {}, modifier)
}