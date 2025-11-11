package com.example.first_movile_app.ui.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.first_movile_app.R
import com.example.first_movile_app.ui.components.InputLabel
import com.example.first_movile_app.ui.components.TextFieldCustom

@Composable
fun CreateTaskScreen(modifier: Modifier = Modifier) {
    Box(modifier = modifier
        .fillMaxSize()
        .padding(16.dp)
    ) {
        Text(text = stringResource(R.string.create_task_title_form))
        Column(
            modifier = Modifier
                .fillMaxWidth()
            ) {
            TextFieldCustom(
                value = "name",
                onValueChange = {},
                placeholder = "Name of the task",
                inputLabel = { InputLabel("Name") })
            Spacer(modifier = Modifier.padding(16.dp))
            TextFieldCustom(
                value = "description",
                onValueChange = {},
                placeholder = "Description of the task",
                inputLabel = { InputLabel("Description") })
        }
    }
}

@Preview
@Composable
fun CreateTaskScreenPreview() {
    CreateTaskScreen()
}