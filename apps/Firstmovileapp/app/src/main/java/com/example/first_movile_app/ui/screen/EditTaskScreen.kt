package com.example.first_movile_app.ui.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.first_movile_app.R
import com.example.first_movile_app.ui.components.InputLabel
import com.example.first_movile_app.ui.components.TextFieldCustom
import com.example.first_movile_app.viewModel.EditTaskViewModel
import com.example.first_movile_app.viewModel.TaskViewModel
import com.example.first_movile_app.viewModel.ViewModalContainer

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun EditTaskScreen(
    modifier: Modifier = Modifier,
    viewModel: EditTaskViewModel = viewModel(factory = ViewModalContainer.Factory)
) {

    val uiState by viewModel.uiState.collectAsState()

    Scaffold(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Box {
            Text(stringResource(R.string.edit_task_title_form))

            Column {
                TextFieldCustom(
                    value = uiState.text,
                    onValueChange = {  },
                    placeholder = stringResource(R.string.create_form_name_placeholder),
                    inputLabel = { InputLabel(value = stringResource(R.string.create_form_name_label)) },
                    errorList = uiState.nameError
                )
                TextFieldCustom(
                    value = uiState.description,
                    onValueChange = {  },
                    placeholder = stringResource(R.string.create_form_name_placeholder),
                    inputLabel = { InputLabel(value = stringResource(R.string.create_form_name_label)) },
                    errorList = uiState.descriptionError
                )
                Button(
                    onClick = {  },
                    enabled = uiState.isLoading
                ) {
                    if (uiState.isLoading) {
                        Text(text = stringResource(R.string.loading_button))
                    } else {
                        Text(text = stringResource(R.string.create_task_button))
                    }
                }
            }
        }
    }
}