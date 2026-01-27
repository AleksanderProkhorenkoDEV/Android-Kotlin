package com.example.authapp.ui.forms.register

data class RegisterForm(
    val name: String = "",
    val nameError: String? = null,
    val email: String = "",
    val emailError: String? = null,
    val password: String = "",
    val passwordError : String? = null,
    val confirmPassword: String = "",
    val confirmPasswordError: String? = null,
    val termsAndConditions: Boolean = false,
    val termsAndConditionsError: String? = null
)