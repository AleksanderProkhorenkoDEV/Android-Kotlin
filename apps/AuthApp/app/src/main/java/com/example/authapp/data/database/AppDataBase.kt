package com.example.authapp.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.authapp.data.dao.TermsDao
import com.example.authapp.data.dao.UserDao
import com.example.authapp.data.entities.TermsEntity
import com.example.authapp.data.entities.UserEntity

@Database(
    entities = [UserEntity::class, TermsEntity::class],
    version = 1,
    exportSchema = false
)
abstract class AppDataBase : RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun termsDao(): TermsDao
    companion object {
        @Volatile
        private var INSTANCE: AppDataBase? = null


        fun getInstance(context: Context): AppDataBase = INSTANCE ?: synchronized(this) {
            INSTANCE ?: buildDatabase(context).also { INSTANCE = it }
        }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                AppDataBase::class.java,
                "AuthDataBase.db"
            )
                .fallbackToDestructiveMigration(true)
                .build()


    }
}