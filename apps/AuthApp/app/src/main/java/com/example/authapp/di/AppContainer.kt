package com.example.authapp.di

import android.content.Context
import com.example.authapp.data.database.AppDataBase
import com.example.authapp.data.repositories.UserRepository
import kotlin.getValue

interface AppContainer {
    val userRepository: UserRepository
}

class AppDataContainer(private val context: Context) : AppContainer {
    private val database by lazy {
        AppDataBase.getInstance(context = context)
    }

    private val userDao by lazy {
        database.userDao()
    }

    private val termsDao by lazy {
        database.termsDao()
    }

    override val userRepository by lazy {
        UserRepository(userDao = database.userDao())
    }


}