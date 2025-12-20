package com.example.first_movile_app.viewModel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class TopAppBarViewModel() : ViewModel() {
    private val _title: MutableStateFlow<String> = MutableStateFlow("Task App")
    val title: StateFlow<String> = _title.asStateFlow()

    fun setTitle(title: String) {
        _title.value = title
    }
}