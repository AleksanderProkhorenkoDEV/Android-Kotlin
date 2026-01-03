package com.example.authapp.navigation

import kotlinx.serialization.Serializable

//Public's routes
@Serializable object Login
@Serializable object Register
@Serializable object ForgotPassword

//Private's routes
@Serializable object Dashboard
@Serializable object Profile