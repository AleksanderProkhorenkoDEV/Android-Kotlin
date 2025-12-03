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
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.first_movile_app.R
import com.example.first_movile_app.ui.components.InputLabel
import com.example.first_movile_app.ui.components.ObserverUiEvents
import com.example.first_movile_app.ui.components.TextFieldCustom
import com.example.first_movile_app.ui.components.TopBar
import com.example.first_movile_app.viewModel.CreateTaskViewModel
import com.example.first_movile_app.viewModel.ViewModalContainer

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun CreateTaskScreen(
    modifier: Modifier = Modifier,
    onNavigationBack: () -> Unit,
    onNavigationList: () -> Unit,
    viewModel: CreateTaskViewModel = viewModel(factory = ViewModalContainer.Factory)
) {
    val uiState = viewModel.uiState.collectAsState()
    val snackbar = remember { SnackbarHostState() }

    ObserverUiEvents(
        events = viewModel.uiEvent,
        snackBarHostState = snackbar,
        onNavigationBack = { onNavigationList() },
        onRetry = { viewModel.saveTask() }
    )

    Scaffold(
        snackbarHost = { SnackbarHost(snackbar) },
        topBar = {
            TopBar(
                screenTitle = stringResource(R.string.create_task_title_form),
                onNavigationBack = onNavigationBack,
            )
        },

    ) { innerPadding ->
        Box(
            modifier = modifier
                .fillMaxSize()
                .padding(innerPadding)
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
                        containerColor = colorResource(R.color.accent_primary),
                        contentColor = colorResource(R.color.primary)
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
}


@Preview
@Composable
fun CreateTaskScreenPreview() {
    CreateTaskScreen(onNavigationBack = {}, onNavigationList = {})
}