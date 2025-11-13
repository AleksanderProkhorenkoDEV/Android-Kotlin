package com.example.first_movile_app.viewModel


import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.first_movile_app.dataBase.entities.Task
import com.example.first_movile_app.dataBase.repositories.OffileTaskRepository
import com.example.first_movile_app.utils.FormError
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

data class CreateTaskFormState(
    val name: String = "",
    val description: String = "",

    val isLoading: Boolean = false,
    val nameError: Set<FormError>? = null,
    val descriptionError: Set<FormError>? = null,
)

class CreateTaskViewModel(
    private val taskRepository: OffileTaskRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(CreateTaskFormState())
    private val _snackbarMessage = MutableSharedFlow<String>()

    val uiState: StateFlow<CreateTaskFormState> = _uiState
    val snackbarMessage = _snackbarMessage.asSharedFlow()

    fun onChangeName(newName: String) {
        _uiState.update { it ->
            it.copy(
                name = newName,
                nameError = validateInputs(newName)
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

    fun saveTask() {

        val currentState = _uiState.value
        val checkedState = currentState.copy(
            nameError = validateInputs(currentState.name),
            descriptionError = validateInputs(currentState.description)
        )

        if (checkedState.descriptionError.isNullOrEmpty() && checkedState.nameError.isNullOrEmpty()) {
            _uiState.update { it ->
                it.copy(
                    isLoading = true
                )
            }
            val task = Task(
                text = checkedState.name,
                description = checkedState.description,
                isChecked = false
            )

            viewModelScope.launch {
                try {
                    taskRepository.insertTask(task)

                    _snackbarMessage.emit("The task was created succesfully")
                } catch (e: Exception) {
                    Log.d("Error", "Error al insertar en la base de datos")
                } finally {
                    Log.d("INFO", "pasa por el finllay")
                    _uiState.update { it ->
                        it.copy(isLoading = false)
                    }
                    _uiState.update { CreateTaskFormState() }
                }
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