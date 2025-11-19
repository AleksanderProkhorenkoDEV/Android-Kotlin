package com.example.first_movile_app.di

import android.content.Context
import com.example.first_movile_app.dataBase.TaskDataBase
import com.example.first_movile_app.dataBase.repositories.OfflineTaskRepository
import com.example.first_movile_app.dataBase.repositories.TaskRepository

interface AppContainer {
    val taskRepository: TaskRepository
}

class AppDataContainer(private val context: Context): AppContainer {
    private val database by lazy {
        TaskDataBase.getInstance(context = context)
    }

    private val taskDao by lazy {
        database.taskDao()
    }

    override val taskRepository by lazy {
        OfflineTaskRepository(taskDao = taskDao)
    }
}