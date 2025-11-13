package com.example.first_movile_app.ui.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.first_movile_app.R
import com.example.first_movile_app.ui.components.InputLabel
import com.example.first_movile_app.ui.components.TextFieldCustom
import com.example.first_movile_app.viewModel.CreateTaskViewModel
import com.example.first_movile_app.viewModel.ViewModalContainer
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun CreateTaskScreen(
    modifier: Modifier = Modifier,
    viewModel: CreateTaskViewModel = viewModel(factory = ViewModalContainer.Factory)
) {
    val uiState = viewModel.uiState.collectAsState()
    val snackbarHostState = remember { SnackbarHostState() }

    LaunchedEffect(true) {
        viewModel.snackbarMessage.collect{ message ->
            snackbarHostState.showSnackbar(message)
        }
    }

    Scaffold(
        snackbarHost = { SnackbarHost(snackbarHostState) },
    ) {
        Box(
            modifier = modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Text(text = stringResource(R.string.create_task_title_form))
            Column(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                TextFieldCustom(
                    value = uiState.value.name,
                    onValueChange = { newName -> viewModel.onChangeName(newName) },
                    placeholder = stringResource(R.string.create_form_name_placeholder),
                    inputLabel = { InputLabel(value = stringResource(R.string.create_form_name_label)) },
                    errorList = uiState.value.nameError
                )
                Spacer(modifier = Modifier.padding(16.dp))
                TextFieldCustom(
                    value = uiState.value.description,
                    onValueChange = { newDescription -> viewModel.onChangeDescription(newDescription) },
                    placeholder = stringResource(R.string.create_form_description_placeholder),
                    inputLabel = { InputLabel(value = stringResource(R.string.create_form_description_label)) },
                    errorList = uiState.value.descriptionError
                )
                Spacer(modifier = Modifier.padding(16.dp))
                Button(
                    onClick = { viewModel.saveTask() },
                    enabled = !uiState.value.isLoading
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
    CreateTaskScreen()
}