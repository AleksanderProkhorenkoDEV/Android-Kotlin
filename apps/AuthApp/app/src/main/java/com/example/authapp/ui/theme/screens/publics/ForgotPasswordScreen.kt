package com.example.authapp.ui.theme.screens.publics

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun ForgotPasswordScreen(
    callbackNavigationBack: () -> Unit,
) {
    Column() {
        Text(text = "Forgot Password Screen")
        Button(onClick = callbackNavigationBack) {
            Text(text = "Go back")
        }
    }
}