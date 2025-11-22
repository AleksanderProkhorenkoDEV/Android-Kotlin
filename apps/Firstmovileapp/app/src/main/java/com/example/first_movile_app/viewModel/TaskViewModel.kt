package com.example.first_movile_app.viewModel


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.first_movile_app.dataBase.entities.Task
import com.example.first_movile_app.dataBase.repositories.TaskRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch


class TaskViewModel(
    private val taskRepository: TaskRepository
) : ViewModel() {

    val tasks: Flow<List<Task>> = taskRepository.getAllTask()

    fun updateChecked(
        task: Task,
        isChecked: Boolean
    ){
        viewModelScope.launch {
            val updateTask = task.copy(isChecked= isChecked)
            taskRepository.updateChecked(updateTask)
        }
    }

    fun deleteTask(task: Task){
        viewModelScope.launch{
            taskRepository.deleteTask(task)
        }
    }
}