package com.example.first_movile_app.viewModel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.toRoute
import com.example.first_movile_app.dataBase.entities.Task
import com.example.first_movile_app.dataBase.repositories.TaskRepository
import com.example.first_movile_app.navigation.EditTask
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn

class EditTaskViewModel(
    savedStateHandle: SavedStateHandle,
    private val taskRepository: TaskRepository,
): ViewModel()
{
    private val _params = savedStateHandle.toRoute<EditTask>()

    private val _task: StateFlow<Task?> = taskRepository.getTask(id = _params.id.toLong())
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = null)

    val uiState: StateFlow<Task?> = _task

}