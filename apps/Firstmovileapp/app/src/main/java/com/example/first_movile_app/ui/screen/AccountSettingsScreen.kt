package com.example.first_movile_app.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier


@Composable
fun AccountSettingsScreen(
) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Text("Personalize your settings")
    }
}