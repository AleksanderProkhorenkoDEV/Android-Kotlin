package com.example.first_movile_app.dataBase.repositories

import com.example.first_movile_app.dataBase.entities.Task
import kotlinx.coroutines.flow.Flow

interface TaskRepository{

    suspend fun insertTask(task: Task)

    fun getAllTask(): Flow<List<Task>>

    fun getTask(id: Long): Flow<Task?>

    suspend fun updateChecked(task: Task)
}