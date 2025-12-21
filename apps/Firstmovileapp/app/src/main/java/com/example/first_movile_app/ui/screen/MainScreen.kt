package com.example.first_movile_app.ui.screen

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.first_movile_app.R
import com.example.first_movile_app.ui.components.ItemListColumn
import com.example.first_movile_app.viewModel.TaskViewModel
import com.example.first_movile_app.viewModel.ViewModalContainer


@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun MainScreen(
    onNavigateToEditScreen: (id: Int) -> Unit,
    modifier: Modifier = Modifier,
    viewModel: TaskViewModel = viewModel(factory = ViewModalContainer.Factory),
) {

    val tasks by viewModel.tasks.collectAsState(initial = emptyList())

    Column(
        modifier = modifier
            .background(color = colorResource(R.color.primary))
            .padding(8.dp)
            .fillMaxSize()
    ) {
        ItemListColumn(
            tasks = tasks,
            onNavigateToEditScreen = onNavigateToEditScreen,
            callbackChangeStatus = { task, isChecked ->
                viewModel.updateChecked(task, isChecked)
            },
            callbackToDelete = { task ->
                viewModel.deleteTask(task)
            }
        )
    }

}

@RequiresApi(Build.VERSION_CODES.O)
@Preview(showBackground = true)
@Composable
fun MainLayoutPreview(
    modifier: Modifier = Modifier
) {
    MainScreen({}, modifier)
}