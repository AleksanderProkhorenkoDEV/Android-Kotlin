package com.example.first_movile_app.dataBase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.first_movile_app.dataBase.dao.TaskDao
import com.example.first_movile_app.dataBase.entities.Task

@Database(entities = [Task::class], version = 1, exportSchema = false)
abstract class  TaskDataBase : RoomDatabase() {

    abstract fun taskDao(): TaskDao

    companion object {
        @Volatile
        private var Instance: TaskDataBase? = null

        fun getInstance(context: Context): TaskDataBase =
            Instance ?: synchronized(this) {
                Instance ?: buildDatabase(context).also { Instance = it }
            }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                TaskDataBase::class.java,
                "task.db"
            )
                .build()
    }
}