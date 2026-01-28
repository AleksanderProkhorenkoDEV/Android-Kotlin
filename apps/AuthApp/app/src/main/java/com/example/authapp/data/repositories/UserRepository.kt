package com.example.authapp.data.repositories

import com.example.authapp.data.dao.ResultDao
import com.example.authapp.data.dao.UserDao
import com.example.authapp.data.entities.UserEntity
import org.mindrot.jbcrypt.BCrypt

class UserRepository(
    private val userDao: UserDao
) {
    suspend fun register(
        name: String,
        email: String,
        password: String,
    ): ResultDao {
        val userEntity = UserEntity(
            name = name,
            email = email,
            password = hashPassword(password)
        )
        val result = userDao.insert(userEntity)

        if(result == -1L) return ResultDao.Error("User already exists")

        return ResultDao.Success(userEntity.copy(id = result.toInt()))
    }

    private fun hashPassword(password: String): String {
        return BCrypt.hashpw(password, BCrypt.gensalt())
    }
}