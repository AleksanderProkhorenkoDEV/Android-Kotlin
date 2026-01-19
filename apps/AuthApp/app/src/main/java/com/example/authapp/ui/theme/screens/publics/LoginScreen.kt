package com.example.authapp.ui.theme.screens.publics

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.authapp.viewModels.AuthState
import com.example.authapp.viewModels.AuthViewModel
import com.example.authapp.viewModels.ViewModelContainer

@Composable
fun LoginScreen(
    callbackNavigationToRegister: () -> Unit,
    callbackNavigationToForgotPassword: () -> Unit,
    callbackOnLoggingSuccess: () -> Unit,
    viewModel: AuthViewModel = viewModel(factory = ViewModelContainer.Factory)
) {

    val authState by viewModel.authState.collectAsState()

    LaunchedEffect(authState) {
        if (authState is AuthState.Authenticated) {
            callbackOnLoggingSuccess()
        }
    }

    Column() {
        Text(text = "Login Screen")
        Button(onClick = callbackNavigationToRegister) {
            Text(text = "You don't have account yet? Create Account")
        }
        Button(onClick = callbackNavigationToForgotPassword) {
            Text(text = "Forgot Password")
        }
        Button(
            onClick = {
                viewModel.login(
                email = "test@gmail.com",
                password = "123456")
            }
        ) {
            Text(text = "Login")
        }
    }
}

@Preview
@Composable
fun LoginScreenPreview() {
    LoginScreen(
        callbackNavigationToRegister = {},
        callbackNavigationToForgotPassword = {},
        callbackOnLoggingSuccess = {}
    )
}