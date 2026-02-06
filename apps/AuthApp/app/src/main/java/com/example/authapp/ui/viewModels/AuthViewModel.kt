package com.example.authapp.ui.viewModels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.authapp.data.dao.ResultDao
import com.example.authapp.data.entities.UserEntity
import com.example.authapp.data.repositories.UserRepository
import com.example.authapp.ui.forms.ValidationResult
import com.example.authapp.ui.forms.register.RegisterEvent
import com.example.authapp.ui.forms.register.RegisterForm
import com.example.authapp.ui.forms.register.RegisterValidator
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

sealed class AuthState {
    object Unauthenticated : AuthState()
    object Loading : AuthState()
    data class Authenticated(val user: UserEntity) : AuthState()
    data class Error(val message: String) : AuthState()
}
class AuthViewModel(
    private val userRepository: UserRepository
) : ViewModel() {
    private val _authState = MutableStateFlow<AuthState>(AuthState.Unauthenticated)
    val authState: StateFlow<AuthState> = _authState.asStateFlow()

    var formState by mutableStateOf(RegisterForm())
        private set

    private val validator = RegisterValidator()

    fun onEvent(event: RegisterEvent) {
        when (event) {
            is RegisterEvent.NameChanged -> {
                formState = formState.copy(name = event.name)
            }

            is RegisterEvent.EmailChanged -> {
                formState = formState.copy(email = event.email)
            }

            is RegisterEvent.PasswordChanged -> {
                formState = formState.copy(password = event.password)
            }

            is RegisterEvent.ConfirmPasswordChanged -> {
                formState = formState.copy(confirmPassword = event.confirmPassword)
            }

            is RegisterEvent.TermsAndConditionsChanged -> {
                formState = formState.copy(termsAndConditions = event.termsAndConditions)
            }

            is RegisterEvent.Submit -> {
                register()
            }
        }
    }

    fun login(email: String, password: String) {
    }

    fun logout() {}

    fun register()  {
        val nameRes = validator.validateName(formState.name)
        val emailRes = validator.validateEmail(formState.email)
        val passRes = validator.validatePassword(formState.password)
        val confirmRes = validator.validateConfirmPassword(formState.password, formState.confirmPassword)
        val termsRes = validator.validateTermsAndConditions(formState.termsAndConditions)

        val hasError = listOf(nameRes, emailRes, passRes, confirmRes).any { !it.isValid }

        formState = formState.copy(
            nameError = (nameRes as? ValidationResult.Error)?.message,
            emailError = (emailRes as? ValidationResult.Error)?.message,
            passwordError = (passRes as? ValidationResult.Error)?.message,
            confirmPasswordError = (confirmRes as? ValidationResult.Error)?.message,
            termsAndConditionsError = (termsRes as? ValidationResult.Error)?.message
        )


        if (!hasError) {
            viewModelScope.launch {
                _authState.value = AuthState.Loading

                val result = userRepository.register(
                    formState.name,
                    formState.email,
                    formState.password
                )

                when (result) {
                    is ResultDao.Success -> {
                        _authState.value = AuthState.Authenticated(result.user)
                        formState = RegisterForm()
                    }

                    is ResultDao.Error -> {
                        _authState.value = AuthState.Error(result.message)
                    }
                }
            }
        }
    }
}