package com.example.authapp.ui.theme.screens.publics

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.authapp.R
import com.example.authapp.ui.forms.register.RegisterEvent
import com.example.authapp.ui.viewModels.AuthViewModel
import com.example.authapp.ui.viewModels.ViewModelContainer

@Composable
fun RegisterScreen(
    callbackNavigationToLogin: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: AuthViewModel = viewModel(factory = ViewModelContainer.Factory)
) {

    val state = viewModel.formState

    Column(
        modifier = modifier
            .padding(16.dp)
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.login),
                contentDescription = "Login Image",
                modifier = Modifier.size(164.dp, 164.dp)
            )
            Text(text = "Register your account")
        }
        Column(
            modifier = modifier
                .padding(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            TextField(
                value = state.name,
                onValueChange = { newName ->
                    viewModel.onEvent(RegisterEvent.NameChanged(newName))
                },
                label = { Text("Write your username") },
                placeholder = { Text("Ej: Mathew") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                modifier = Modifier.fillMaxWidth(),
                isError = state.nameError != null,
                supportingText = {
                    state.nameError?.let { Text(text = it) }
                }
            )
            TextField(
                value = state.email,
                onValueChange = { newEmail ->
                    viewModel.onEvent(RegisterEvent.EmailChanged(newEmail))
                },
                label = { Text("Write email") },
                placeholder = { Text("Ej: mathew@gmail.com") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                modifier = Modifier.fillMaxWidth(),
                isError = state.emailError != null,
                supportingText = {
                    state.emailError?.let { Text(text = it) }
                }
            )
            TextField(
                value = state.password,
                onValueChange = { newPassword ->
                    viewModel.onEvent(RegisterEvent.PasswordChanged(newPassword))
                },
                label = { Text("Write your password") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                modifier = Modifier.fillMaxWidth(),
                visualTransformation = PasswordVisualTransformation(),
                isError = state.passwordError != null,
                supportingText = {
                    state.passwordError?.let { Text(text = it) }
                }
            )
            TextField(
                value = state.confirmPassword,
                onValueChange = { newConfirmPassword ->
                    viewModel.onEvent(RegisterEvent.ConfirmPasswordChanged(newConfirmPassword))
                },
                label = { Text("Confirm your password") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                modifier = Modifier.fillMaxWidth(),
                visualTransformation = PasswordVisualTransformation(),
                isError = state.confirmPasswordError != null,
                supportingText = {
                    state.confirmPasswordError?.let { Text(text = it) }
                }
            )
        }
        Column {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Checkbox(
                    checked = state.termsAndConditions,
                    onCheckedChange = { newTermAndCondition ->
                        viewModel.onEvent(
                            RegisterEvent.TermsAndConditionsChanged(
                                newTermAndCondition
                            )
                        )
                    }
                )
                Text(
                    text = "I agree to the terms and conditions"
                )
            }
            if (state.termsAndConditionsError != null) {
                Text(
                    text = state.termsAndConditionsError,
                    color = MaterialTheme.colorScheme.error,
                    style = MaterialTheme.typography.bodySmall,
                    modifier = Modifier.padding(start = 12.dp)
                )
            }
        }
        Row(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxSize(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(
                text = "Do you have an account?"
            )
            Text(
                text = "Sign In",
                style = TextStyle(color = Color.Blue),
                modifier = Modifier.clickable {
                    callbackNavigationToLogin()
                }
            )
        }
        Button(
            onClick = {
                viewModel.register()
            }
        ) {
            Text(
                text = "Register Account"
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RegisterScreenPreview() {
    RegisterScreen(
        callbackNavigationToLogin = {}
    )
}