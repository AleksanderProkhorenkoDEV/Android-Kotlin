package com.example.authapp.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.authapp.data.dao.UserDao
import com.example.authapp.data.entities.UserEntity

@Database(
    entities = [UserEntity::class],
    version=1,
    exportSchema = false)
abstract class AppDataBase: RoomDatabase() {
    abstract fun userDao(): UserDao

    companion object{
        @Volatile
        private var INSTANCE: AppDataBase? = null

        fun getDataBase(context: Context): AppDataBase{
            return INSTANCE ?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDataBase::class.java,
                    "AuthDataBase"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}