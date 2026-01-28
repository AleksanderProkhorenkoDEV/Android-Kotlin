package com.example.authapp.data.dao

import com.example.authapp.data.entities.UserEntity

sealed class ResultDao {
    data class Success(val user: UserEntity): ResultDao()
    data class Error(val message: String): ResultDao()
}