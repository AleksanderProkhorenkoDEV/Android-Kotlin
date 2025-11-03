package com.example.first_movile_app.dataBase.repositories

import com.example.first_movile_app.dataBase.dao.TaskDao
import com.example.first_movile_app.dataBase.entities.Task

class OffileTaskRepository(private val taskDao: TaskDao): TaskRespository {

    override suspend fun insertTask(task: Task) = taskDao.insert(task)
}