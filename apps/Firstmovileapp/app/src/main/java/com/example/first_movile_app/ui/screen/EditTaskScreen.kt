package com.example.first_movile_app.ui.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
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
    id: Int,
    modifier: Modifier = Modifier,

) {

    Scaffold(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Box {
            Text(stringResource(R.string.edit_task_title_form))

            Column {
                TextFieldCustom(
                    value = "",
                    onValueChange = { newName -> "" },
                    placeholder = stringResource(R.string.create_form_name_placeholder),
                    inputLabel = { InputLabel(value = stringResource(R.string.create_form_name_label)) },
                    errorList = null
                )
                TextFieldCustom(
                    value = "",
                    onValueChange = { newName -> "" },
                    placeholder = stringResource(R.string.create_form_name_placeholder),
                    inputLabel = { InputLabel(value = stringResource(R.string.create_form_name_label)) },
                    errorList = null
                )
            }
        }
    }
}