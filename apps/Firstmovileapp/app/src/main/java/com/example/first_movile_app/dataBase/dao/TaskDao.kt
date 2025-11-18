package com.example.first_movile_app.dataBase.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.first_movile_app.dataBase.entities.Task
import kotlinx.coroutines.flow.Flow

@Dao
interface TaskDao{

    @Insert
    suspend fun insert(task: Task)

    @Query("SELECT * FROM tasks")
    fun getAllTask(): Flow<List<Task>>

    @Query("SELECT * FROM tasks where id = :id")
    fun getTask(id: Long): Flow<Task?>

    @Update
    suspend fun updateChecked(task: Task)
}