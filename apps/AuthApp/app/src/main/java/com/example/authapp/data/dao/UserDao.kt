package com.example.authapp.data.dao

import androidx.room.Dao
import androidx.room.Query
import com.example.authapp.data.entities.User

@Dao
interface UserDao {
    @Query("SELECT * FROM users")
    fun getAll(): List<User>
}