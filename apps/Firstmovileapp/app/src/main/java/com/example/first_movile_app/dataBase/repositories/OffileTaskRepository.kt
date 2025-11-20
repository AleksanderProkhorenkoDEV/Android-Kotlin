package com.example.first_movile_app.dataBase.repositories

import com.example.first_movile_app.dataBase.dao.TaskDao
import com.example.first_movile_app.dataBase.entities.Task
import kotlinx.coroutines.flow.Flow

class OfflineTaskRepository(private val taskDao: TaskDao): TaskRepository {

    override suspend fun insertTask(task: Task) = taskDao.insert(task)

    override suspend fun updateTask(task: Task) = taskDao.update(task)

    override fun getAllTask(): Flow<List<Task>> = taskDao.getAllTask()

    override fun getTask(id: Long): Flow<Task> = taskDao.getTask(id = id)

    override suspend fun updateChecked(task: Task) = taskDao.updateChecked(task)
}