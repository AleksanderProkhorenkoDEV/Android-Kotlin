package com.example.authapp.ui.viewModels

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.authapp.AuthApplication

object ViewModelContainer{
    val Factory = viewModelFactory {
        initializer<AuthViewModel> {
            AuthViewModel(userRepository = authApplication().container.userRepository)
        }
    }
}

fun CreationExtras.authApplication(): AuthApplication =
    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as AuthApplication)
