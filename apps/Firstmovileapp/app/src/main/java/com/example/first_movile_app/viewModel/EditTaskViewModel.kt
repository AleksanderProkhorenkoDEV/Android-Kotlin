package com.example.first_movile_app.viewModel

import android.util.Log
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.toRoute
import com.example.first_movile_app.dataBase.repositories.TaskRepository
import com.example.first_movile_app.navigation.EditTask
import com.example.first_movile_app.utils.FormError
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch


data class EditTaskFormState(
    val id: Int = 0,
    val text: String = "",
    val description: String = "",
    val isChecked: Boolean = false,

    val isLoading: Boolean = false,
    val nameError: Set<FormError>? = null,
    val descriptionError: Set<FormError>? = null,
)

class EditTaskViewModel(
    savedStateHandle: SavedStateHandle,
    private val taskRepository: TaskRepository,
) : ViewModel() {
    private val _params = savedStateHandle.toRoute<EditTask>()
    private val _snackbarMessage = MutableSharedFlow<String>()
    val snackbarMessage = _snackbarMessage.asSharedFlow()

    private val _uiState = MutableStateFlow(EditTaskFormState())
    val uiState: StateFlow<EditTaskFormState> = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            val task = taskRepository.getTask(_params.id.toLong()).first()
            _uiState.update { currentState ->
                currentState.copy(
                    id = task.id.toInt(),
                    text = task.text,
                    description = task.description,
                    isChecked = task.isChecked
                )
            }
        }
    }


}