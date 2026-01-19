package com.example.authapp.viewModels

data class User(
    val email: String,
    val name: String = email.substringBefore("@")
)
