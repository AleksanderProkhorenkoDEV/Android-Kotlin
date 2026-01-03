package com.example.authapp.ui.theme.screens.publics

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun RegisterScreen(
    callbackNavigationToLogin: () -> Unit
) {
    Column() {
        Text(text = "Register Screen")
        Button(onClick = callbackNavigationToLogin) {
            Text(text = "Sign In")
        }
    }
}

@Preview
@Composable
fun RegisterScreenPreview() {
    RegisterScreen(
        callbackNavigationToLogin = {}
    )
}