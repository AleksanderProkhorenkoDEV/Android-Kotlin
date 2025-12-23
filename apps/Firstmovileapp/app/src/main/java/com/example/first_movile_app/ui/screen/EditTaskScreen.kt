package com.example.first_movile_app.ui.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.first_movile_app.R
import com.example.first_movile_app.ui.components.inputs.InputLabel
import com.example.first_movile_app.ui.components.ObserverUiEvents
import com.example.first_movile_app.ui.components.inputs.TextFieldCustom
import com.example.first_movile_app.viewModel.EditTaskViewModel
import com.example.first_movile_app.viewModel.ViewModalContainer

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun EditTaskScreen(
    snackbarHostState: SnackbarHostState,
    onNavigationList: () -> Unit,
    viewModel: EditTaskViewModel = viewModel(factory = ViewModalContainer.Factory)
) {

    val uiState by viewModel.uiState.collectAsState()

    ObserverUiEvents(
        events = viewModel.uiEvent,
        snackBarHostState = snackbarHostState,
        onNavigationBack = { onNavigationList() },
        onRetry = { viewModel.updateTask() }
    )

    Column(
        modifier = Modifier
            .background(color = MaterialTheme.colorScheme.background)
            .padding(8.dp)
            .fillMaxSize(),
    ) {
        TextFieldCustom(
            value = uiState.text,
            onValueChange = { newText -> viewModel.onChangeText(newText) },
            placeholder = stringResource(R.string.create_form_name_placeholder),
            inputLabel = { InputLabel(value = stringResource(R.string.create_form_name_label)) },
            errorList = uiState.nameError
        )
        Spacer(modifier = Modifier.padding(12.dp))
        TextFieldCustom(
            value = uiState.description,
            onValueChange = { newDescription -> viewModel.onChangeDescription(newDescription) },
            placeholder = stringResource(R.string.create_form_name_placeholder),
            inputLabel = { InputLabel(value = stringResource(R.string.create_form_name_label)) },
            errorList = uiState.descriptionError
        )
        Spacer(modifier = Modifier.padding(12.dp))
        Button(
            onClick = { viewModel.updateTask() },
            enabled = !uiState.isLoading,
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.tertiary,
                contentColor = MaterialTheme.colorScheme.onTertiary
            )
        ) {
            if (uiState.isLoading) {
                Text(text = stringResource(R.string.loading_button))
            } else {
                Text(text = stringResource(R.string.edit_task))
            }
        }
    }
}