package com.example.first_movile_app.ui.components.buttons

import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable

@Composable
fun ActionButton (
    icon: @Composable () -> Unit,
    onClickAction: () -> Unit
) {
    IconButton(onClick = onClickAction) {
        icon()
    }
}