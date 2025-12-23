package com.example.first_movile_app.ui.components.buttons

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun ExpandButton(
    isExpanded: Boolean = false,
    callbackExpanded: (Boolean) -> Unit
){
    IconButton(
        onClick = { callbackExpanded(isExpanded) },
    ){
        Icon(
            imageVector = if(isExpanded) Icons.Default.KeyboardArrowUp else Icons.Default.KeyboardArrowDown,
            contentDescription = "Expand",
            tint = MaterialTheme.colorScheme.onSurface
        )
    }
}

@Preview(showBackground = false)
@Composable
fun ExpandButtonPreview(){
    ExpandButton(callbackExpanded = {})
}