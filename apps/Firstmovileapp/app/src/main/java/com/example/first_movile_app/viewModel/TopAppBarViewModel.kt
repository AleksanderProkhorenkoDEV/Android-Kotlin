package com.example.first_movile_app.viewModel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update


data class TopAppBarState(
    val title: String = "",
    val canNavigateBack: Boolean = false
)

class TopAppBarViewModel() : ViewModel() {
    private val _uiState: MutableStateFlow<TopAppBarState> = MutableStateFlow(TopAppBarState())
    val uiState: StateFlow<TopAppBarState> = _uiState.asStateFlow()

    fun updateTopAppBar(title: String, canNavigateBack: Boolean) {
        _uiState.update { it.copy(title = title, canNavigateBack = canNavigateBack) }
    }
}