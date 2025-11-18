package com.example.first_movile_app.viewModel

import androidx.lifecycle.ViewModel
import com.example.first_movile_app.dataBase.entities.Task
import com.example.first_movile_app.dataBase.repositories.TaskRepository
import kotlinx.coroutines.flow.StateFlow

class EditTaskViewModel(
    private val taskRepository: TaskRepository,
): ViewModel()
{

}