package com.example.first_movile_app.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.first_movile_app.R
import com.example.first_movile_app.viewModel.TaskViewModel


@Composable
fun MainLayout(
    modifier: Modifier = Modifier,
    viewModel: TaskViewModel = viewModel(),
) {

    val task by viewModel.tasks.collectAsState()

    Column(
        modifier = modifier
            .padding(8.dp)
            .fillMaxSize()
    ) {
        Text(text = stringResource(R.string.app_name))
        ItemListColumn(task, callbackChangeStatus = {
            task, checked -> viewModel.changeTaskStatus(task, checked)
        })
    }
}

@Preview(showBackground = true)
@Composable
fun MainLayoutPreview(
    modifier: Modifier = Modifier
) {
    MainLayout(modifier)
}