package com.example.first_movile_app.ui.components

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.first_movile_app.dataBase.entities.Task

@Composable
fun ItemListColumn(
    tasks: List<Task>,
    onNavigateToEditScreen: (id: Int) -> Unit,
    callbackChangeStatus: (Task, Boolean) -> Unit,
    callbackToDelete: (task: Task) -> Unit,
    modifier: Modifier = Modifier,
) {

    LazyColumn(
        modifier = modifier,
    ) {
        items(
            items = tasks,
            key = { task -> task.id }
        ) { taskItem ->
            ItemTask(
                task = taskItem,
                isChecked = taskItem.isChecked,
                onNavigateToEditScreen = onNavigateToEditScreen,
                callbackChecked = { checked -> callbackChangeStatus(taskItem, checked) },
                callbackToDelete = callbackToDelete
                ,
            )
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview(showBackground = true)
@Composable
fun ItemListColumnPreview() {
    val tasks = listOf<Task>(
        Task(id = 1, text = "Finish the App", description = "a lot of text", true),
        Task(id = 2, text = "Learn compose", description = "a lot of text", false),
        Task(id = 3, text = "make my first mobile app", description = "a lot of text", false),
        Task(id = 4, text = "Became a senior developer", description = "a lot of text",  false),
    )

    ItemListColumn(
        tasks = tasks,
        onNavigateToEditScreen = {},
        callbackChangeStatus = { tasks, checked -> true },
        callbackToDelete = {},
    )
}