package com.example.authapp.data.repositories

import android.content.Context
import com.example.authapp.data.database.AppDataBase

class UserRepository(private val context: Context) {

    private val database by lazy {
        AppDataBase.getDataBase(context)
    }

    suspend fun register(){}
}