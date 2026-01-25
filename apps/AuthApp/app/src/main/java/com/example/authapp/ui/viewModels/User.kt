package com.example.authapp.ui.viewModels

data class User(
    val email: String,
    val name: String = email.substringBefore("@")
)
