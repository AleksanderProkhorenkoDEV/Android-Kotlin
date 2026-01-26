package com.example.authapp.ui.forms


data class RegisterForm(
    val name: String = "",
    val email: String = "",
    val password: String = "",
    val confirmPassword: String = "",
    val termsAndConditions: Boolean = false
) {
    fun validate(): ValidationResult {
        return when {
            email.isBlank() -> ValidationResult.Error("The email field is required")
            !email.contains("@") -> ValidationResult.Error("invalid email, example: example@gmail.com")
            password.length < 6 -> ValidationResult.Error("The password field minimun length is 6 characters")
            password != confirmPassword -> ValidationResult.Error("The password and confirm password fields must match")
            !termsAndConditions -> ValidationResult.Error("You must accept the terms and conditions")
            else -> ValidationResult.Success
        }
    }

    fun getNameError(): String? {
        if (name.isEmpty()) return null
        return when {
            name.isBlank() -> "invalid name, can't be blank"
            else -> null
        }
    }

    fun getEmailError(): String? {
        if (email.isEmpty()) return null
        return when {
            email.isBlank() -> "The email field is required"
            !email.contains("@") -> "invalid email, example: example@gmail.com"
            else -> null
        }
    }

    fun getPasswordError(): String? {
        if (password.isEmpty()) return null

        return when {
            password.length < 6 -> "The password field minimun length is 6 characters"
            else -> null
        }
    }

    fun getConfirmPasswordError(): String? {

        if (confirmPassword.isEmpty()) return null

        return when {
            password != confirmPassword -> "The password and confirm password fields must match"
            else -> null
        }
    }
}
