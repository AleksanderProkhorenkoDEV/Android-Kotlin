package com.example.first_movile_app.ui.components

import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import com.example.first_movile_app.viewModel.SnackAction
import com.example.first_movile_app.viewModel.UiEvent
import kotlinx.coroutines.flow.SharedFlow

@Composable
fun ObserverUiEvents(
    events: SharedFlow<UiEvent>,
    snackBarHostState: SnackbarHostState,
    onNavigationBack: () -> Unit = {},
    onRetry: () -> Unit = {}
){
    LaunchedEffect(Unit) {
       events.collect { event ->
            when (event) {
                is UiEvent.SnackMessage -> {
                    snackBarHostState.showSnackbar(
                        message = event.message,
                        duration = SnackbarDuration.Short,
                        actionLabel = event.actionLabel
                    ).let { result ->
                        if (result == SnackbarResult.ActionPerformed){
                            when(event.onAction){
                                SnackAction.None -> { /*No action*/ }
                                SnackAction.NavigateBack -> onNavigationBack()
                                SnackAction.Retry -> onRetry()
                            }
                        }
                    }
                }
            }
        }
    }
}