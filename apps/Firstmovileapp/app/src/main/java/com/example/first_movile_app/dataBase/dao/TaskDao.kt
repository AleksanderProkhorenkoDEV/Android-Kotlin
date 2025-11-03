package com.example.first_movile_app.dataBase.dao

import androidx.room.Dao
import androidx.room.Insert
import com.example.first_movile_app.dataBase.entities.Task

@Dao
interface TaskDao{

    @Insert
    suspend fun insert(task: Task)

}