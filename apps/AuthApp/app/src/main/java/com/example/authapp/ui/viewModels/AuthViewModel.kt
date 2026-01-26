package com.example.authapp.ui.viewModels

import androidx.lifecycle.ViewModel
import com.example.authapp.ui.forms.RegisterForm
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

sealed class AuthState{
    object Unauthenticated : AuthState()
    object Loading: AuthState()
    data class Authenticated(val user: User): AuthState()
    data class Error(val message: String): AuthState()
}

class AuthViewModel: ViewModel() {
    private val _authState = MutableStateFlow<AuthState>(AuthState.Unauthenticated)
    val authState: StateFlow<AuthState> = _authState.asStateFlow()

    private val _registerFormState = MutableStateFlow<RegisterForm>(RegisterForm())
    val registerState: StateFlow<RegisterForm> = _registerFormState.asStateFlow()

    fun updateRegisterForm(newForm: RegisterForm) {
        _registerFormState.value = newForm
    }

    fun login(email: String, password: String){
    }

    fun logout(){}

    fun register(){}
}