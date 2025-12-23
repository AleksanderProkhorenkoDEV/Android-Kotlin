package com.example.first_movile_app.ui.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.first_movile_app.R
import com.example.first_movile_app.ui.components.inputs.InputLabel
import com.example.first_movile_app.ui.components.ObserverUiEvents
import com.example.first_movile_app.ui.components.inputs.TextFieldCustom
import com.example.first_movile_app.viewModel.CreateTaskViewModel
import com.example.first_movile_app.viewModel.ViewModalContainer

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun CreateTaskScreen(
    modifier: Modifier = Modifier,
    snackbarHostState: SnackbarHostState,
    onNavigationList: () -> Unit,
    viewModel: CreateTaskViewModel = viewModel(factory = ViewModalContainer.Factory)
) {
    val uiState = viewModel.uiState.collectAsState()

    ObserverUiEvents(
        events = viewModel.uiEvent,
        snackBarHostState = snackbarHostState,
        onNavigationBack = { onNavigationList() },
        onRetry = { viewModel.saveTask() }
    )

    Box(
        modifier = modifier
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            TextFieldCustom(
                value = uiState.value.name,
                onValueChange = { newName -> viewModel.onChangeName(newName) },
                placeholder = stringResource(R.string.create_form_name_placeholder),
                inputLabel = { InputLabel(value = stringResource(R.string.create_form_name_label)) },
                errorList = uiState.value.nameError
            )
            Spacer(modifier = Modifier.padding(12.dp))
            TextFieldCustom(
                value = uiState.value.description,
                onValueChange = { newDescription -> viewModel.onChangeDescription(newDescription) },
                placeholder = stringResource(R.string.create_form_description_placeholder),
                inputLabel = { InputLabel(value = stringResource(R.string.create_form_description_label)) },
                errorList = uiState.value.descriptionError
            )
            Spacer(modifier = Modifier.padding(12.dp))
            Button(
                onClick = { viewModel.saveTask() },
                enabled = !uiState.value.isLoading,
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    contentColor = MaterialTheme.colorScheme.onPrimary
                )
            ) {
                if (uiState.value.isLoading) {
                    Text(text = stringResource(R.string.loading_button))
                } else {
                    Text(text = stringResource(R.string.create_task_button))
                }
            }
        }

    }

}