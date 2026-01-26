package com.example.authapp.ui.viewModels

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.authapp.ui.forms.RegisterForm
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

sealed class AuthState {
    object Unauthenticated : AuthState()
    object Loading : AuthState()
    data class Authenticated(val user: User) : AuthState()
    data class Error(val message: String) : AuthState()
}

class AuthViewModel : ViewModel() {
    private val _authState = MutableStateFlow<AuthState>(AuthState.Unauthenticated)
    val authState: StateFlow<AuthState> = _authState.asStateFlow()

    private val _registerFormState = MutableStateFlow<RegisterForm>(RegisterForm())
    val registerState: StateFlow<RegisterForm> = _registerFormState.asStateFlow()

    private val _registerErrors = MutableStateFlow<Map<String, String>>(emptyMap())
    val registerErrors: StateFlow<Map<String, String>> = _registerErrors.asStateFlow()

    fun updateRegisterForm(newForm: RegisterForm) {
        _registerFormState.value = newForm
        val errors = mutableMapOf<String, String>()

        newForm.getNameError()?.let { errors["name"] = it }
        newForm.getEmailError()?.let { errors["email"] = it }
        newForm.getPasswordError()?.let { errors["password"] = it }
        newForm.getConfirmPasswordError()?.let { errors["confirmPassword"] = it }

        _registerErrors.value = errors
    }

    fun login(email: String, password: String) {
    }

    fun logout() {}

    fun register(user: RegisterForm) {
        Log.d("Register", user.toString())
    }
}