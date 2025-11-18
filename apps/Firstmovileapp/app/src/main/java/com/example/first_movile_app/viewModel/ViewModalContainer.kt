package com.example.first_movile_app.viewModel

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.first_movile_app.TaskApplication

object ViewModalContainer {
    val Factory = viewModelFactory {
        initializer {
            TaskViewModel(taskRepository = taskApplication().container.taskRepository)
        }
        initializer {
            CreateTaskViewModel(taskRepository = taskApplication().container.taskRepository)
        }
        initializer {
            EditTaskViewModel(taskRepository = taskApplication().container.taskRepository)
        }
    }
}

fun CreationExtras.taskApplication(): TaskApplication =
    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as TaskApplication)