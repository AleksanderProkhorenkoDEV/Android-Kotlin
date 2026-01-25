package com.example.authapp.ui.forms

import androidx.room.RoomOpenDelegate

data class RegisterForm(
    val name: String = "",
    val email: String = "",
    val password: String = "",
    val confirmPassword: String = ""
){
    fun validate(): ValidationResult {
        return when{
            email.isBlank() -> ValidationResult.Error("The email field is required")
            !email.contains("@") -> ValidationResult.Error("invalid email, example: example@gmail.com")
            password.length < 6 -> ValidationResult.Error("The password field minimun length is 6 characters")
            password != confirmPassword -> ValidationResult.Error("The password and confirm password fields must match")
            else -> ValidationResult.Success
        }
    }
}
