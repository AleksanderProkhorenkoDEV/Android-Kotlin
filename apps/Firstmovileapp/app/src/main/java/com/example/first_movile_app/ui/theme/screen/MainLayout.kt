package com.example.first_movile_app.ui.theme.screen

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.first_movile_app.R
import com.example.first_movile_app.components.ItemListColumn
import com.example.first_movile_app.dataBase.entities.Task
import com.example.first_movile_app.ui.theme.viewModel.TaskViewModel
import com.example.first_movile_app.ui.theme.viewModel.ViewModalContainer
import kotlinx.coroutines.flow.Flow


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun MainLayout(
    modifier: Modifier = Modifier,
    viewModel: TaskViewModel = viewModel(factory = ViewModalContainer.Factory),
) {

    val tasks by viewModel.tasks.collectAsState(initial = emptyList())

    Column(
        modifier = modifier
            .padding(8.dp)
            .fillMaxSize()
    ) {
        Text(
            text = stringResource(R.string.app_name).uppercase(),
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(vertical = 6.dp)
                .fillMaxWidth()
            )
        ItemListColumn(
            tasks = tasks,
            callbackChangeStatus = {task, isChecked ->
                viewModel.updateChecked(task, isChecked)
            },
        )
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview(showBackground = true)
@Composable
fun MainLayoutPreview(
    modifier: Modifier = Modifier
) {
    MainLayout(modifier)
}