package com.example.authapp.ui.forms.register

sealed class RegisterEvent {
    data class NameChanged(val name: String): RegisterEvent()
    data class EmailChanged(val email: String): RegisterEvent()
    data class PasswordChanged(val password: String) : RegisterEvent()
    data class ConfirmPasswordChanged(val confirmPassword: String) : RegisterEvent()
    data class TermsAndConditionsChanged(val termsAndConditions: Boolean) : RegisterEvent()
    object Submit : RegisterEvent()
}