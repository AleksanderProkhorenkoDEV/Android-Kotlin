package com.example.authapp.ui.forms.register

import com.example.authapp.ui.forms.ValidationResult

class RegisterValidator {

    fun validateName(name: String): ValidationResult {
        if (name.isBlank()) return ValidationResult.Error("invalid name, must be filled")
        return ValidationResult.Success
    }

    fun validateEmail(email: String): ValidationResult {
        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            return ValidationResult.Error("invalid email, must be a valid email, ex: example@gmail.com")
        }
        return ValidationResult.Success
    }

    fun validatePassword(password: String): ValidationResult {
        if (password.length < 8) return ValidationResult.Error("Invalid password, must be at least 8 characters")
        return ValidationResult.Success
    }

    fun validateConfirmPassword(password: String, confirm: String): ValidationResult {
        if (password != confirm) return ValidationResult.Error("Invalid confirm password, must be the same as password")
        return ValidationResult.Success
    }

    fun validateTermsAndConditions(termsAndConditions: Boolean): ValidationResult {
        if (!termsAndConditions) return ValidationResult.Error("You must be accept the terms and conditions")
        return ValidationResult.Success
    }

}