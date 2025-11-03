package com.example.first_movile_app.dataBase.repositories

import com.example.first_movile_app.dataBase.entities.Task

interface TaskRespository {

    suspend fun insertTask(task: Task)
}