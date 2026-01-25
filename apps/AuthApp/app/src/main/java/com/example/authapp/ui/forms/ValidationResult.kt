package com.example.authapp.ui.forms

sealed class ValidationResult {
    object Success : ValidationResult()

    data class Error(val message: String) : ValidationResult()

    val isValid: Boolean
        get() = this is Success
}