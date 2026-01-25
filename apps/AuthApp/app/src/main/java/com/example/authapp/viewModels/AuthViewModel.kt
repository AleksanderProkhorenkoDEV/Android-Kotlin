package com.example.authapp.viewModels

import androidx.lifecycle.ViewModel
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

    fun login(email: String, password: String){
    }

    fun logout(){}

    fun register(){}
}