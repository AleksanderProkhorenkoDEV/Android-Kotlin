package com.example.first_movile_app.viewModel

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.toRoute
import com.example.first_movile_app.dataBase.entities.Task
import com.example.first_movile_app.dataBase.repositories.TaskRepository
import com.example.first_movile_app.navigation.EditTask
import com.example.first_movile_app.utils.FormError
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
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

    private val _uiState = MutableStateFlow(EditTaskFormState())
    val uiState: StateFlow<EditTaskFormState> = _uiState.asStateFlow()

    private val _uiEvent = MutableSharedFlow<UiEvent>(replay = 0, extraBufferCapacity = 1)
    val uiEvent: SharedFlow<UiEvent> = _uiEvent.asSharedFlow()

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

    fun onChangeText(newText: String) {
        _uiState.update { it ->
            it.copy(
                text = newText,
                nameError = validateInputs(newText)
            )
        }
    }

    fun onChangeDescription(newDescription: String) {
        _uiState.update { it ->
            it.copy(
                description = newDescription,
                descriptionError = validateInputs(newDescription)
            )
        }
    }

    fun updateTask() {
        val currentState = _uiState.value
        val checkState = currentState.copy(
            nameError = validateInputs(currentState.text),
            descriptionError = validateInputs(currentState.description)
        )

        if (!checkState.descriptionError.isNullOrEmpty() || !checkState.nameError.isNullOrEmpty()) {
            _uiState.update {
                it.copy(
                    nameError = checkState.nameError,
                    descriptionError = checkState.descriptionError
                )
            }
            return
        }


        _uiState.update { it.copy(isLoading = true) }

        viewModelScope.launch {
            try {
                taskRepository.updateTask(task = createTask(states = currentState))
                _uiEvent.emit(
                    value = UiEvent.SnackMessage(
                        message = "Task update successfully",
                        actionLabel = "View Task",
                        onAction = SnackAction.NavigateBack
                    )
                )
            } catch (e: Exception) {
                Log.d("Error", "Error al updatear la tarea")
                _uiEvent.emit(
                    value = UiEvent.SnackMessage(
                        message = "An unexpected error has occurred.",
                        actionLabel = "Retry",
                        onAction = SnackAction.Retry
                    )
                )
                _uiState.update {
                    EditTaskFormState(
                        id = currentState.id,
                        text = currentState.text,
                        description = currentState.description,
                        isChecked = currentState.isChecked
                    )
                }
            } finally {
                _uiState.update { it.copy(isLoading = false) }
            }
        }

    }
}

private fun validateInputs(value: String): Set<FormError> {
    val errors = mutableSetOf<FormError>()
    if (value.isEmpty()) {
        errors.add(FormError.EMPTY_FIELD)
    }

    if (value.length >= 254) {
        errors.add(FormError.TOO_LONG)
    }

    return errors
}

private fun createTask(states: EditTaskFormState): Task {
    return Task(
        text = states.text,
        description = states.description,
        isChecked = false
    )
}