package com.example.authapp.ui.theme.screens.publics

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun LoginScreen(
    callbackNavigationToRegister: () -> Unit,
    callbackNavigationToForgotPassword: () -> Unit,
) {
    Column() {
        Text(text = "Login Screen")
        Button(onClick = callbackNavigationToRegister) {
            Text(text = "Create Account")
        }
        Button(onClick = callbackNavigationToForgotPassword) {
            Text(text = "Forgot Password")
        }
    }
}

@Preview
@Composable
fun LoginScreenPreview() {
    LoginScreen(
        callbackNavigationToRegister = {},
        callbackNavigationToForgotPassword = {}
    )
}