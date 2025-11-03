package com.example.first_movile_app.di

import android.content.Context
import com.example.first_movile_app.dataBase.TaskDataBase
import com.example.first_movile_app.dataBase.repositories.OffileTaskRepository

class AppContainer(private val context: Context) {
    private val database by lazy {
        TaskDataBase.getInstance(context = context)
    }

    private val taskDao by lazy {
        database.taskDao()
    }

    private val taskRepository by lazy {
        OffileTaskRepository(taskDao = taskDao)
    }
}