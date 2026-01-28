package com.example.authapp

import android.app.Application
import com.example.authapp.di.AppDataContainer

class AuthApplication : Application() {
    val container by lazy {
        AppDataContainer(this)
    }
}