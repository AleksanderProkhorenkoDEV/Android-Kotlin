package com.example.first_movile_app.components

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.first_movile_app.data.Task

@Composable
fun ItemListColumn(
    tasks: List<Task>,
    callbackChangeStatus: (Task, Boolean) -> Unit,
    modifier: Modifier = Modifier,
){
    LazyColumn(
        modifier = modifier,
    ) {
        items(
            items = tasks,
            key = { task -> task.id}
        ){taskItem ->
            ItemTask(
                text = taskItem.text,
                isChecked = taskItem.checked,
                callbackChecked = { checked -> callbackChangeStatus(taskItem, checked) }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ItemListColumnPreview(){
    val tasks = listOf<Task>(
        Task(id = 1, text = "Finish the App"),
        Task(id = 2, text = "Learn compose"),
        Task(id = 3, text = "make my first mobile app"),
        Task(id = 4, text = "Became a senior developer"),
    )

    ItemListColumn(tasks = tasks, {tasks, checked -> true})
}