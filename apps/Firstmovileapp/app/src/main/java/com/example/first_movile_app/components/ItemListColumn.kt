package com.example.first_movile_app.components

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
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
