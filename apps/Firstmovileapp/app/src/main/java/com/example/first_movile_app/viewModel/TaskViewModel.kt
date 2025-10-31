package com.example.first_movile_app.viewModel

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModel
import com.example.first_movile_app.data.Task
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import java.time.LocalDate


@RequiresApi(Build.VERSION_CODES.O)
class TaskViewModel : ViewModel() {
    private val _task = MutableStateFlow<List<Task>>(emptyList())
    val tasks: StateFlow<List<Task>>
        get() = _task.asStateFlow()

    init {
        _task.value = listOf<Task>(
            Task(id = 1, text = "Finish the App", description = "a lot of text", endDate = LocalDate.now()),
            Task(id = 2, text = "Learn compose", description = "a lot of text", endDate = LocalDate.now()),
            Task(id = 3, text = "make my first mobile app", description = "a lot of text", endDate = LocalDate.now()),
            Task(id = 4, text = "Became a senior developer", description = "a lot of text", endDate = LocalDate.now()),
        )
    }

    fun changeTaskStatus(item: Task, checked: Boolean) {
        _task.value.find { it.id == item.id }?.let{ task ->
            task.checked = checked
        }
    }
}