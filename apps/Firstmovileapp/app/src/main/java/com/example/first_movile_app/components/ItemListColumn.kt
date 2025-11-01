package com.example.first_movile_app.components

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.first_movile_app.dataBase.Task
import java.time.LocalDate

@Composable
fun ItemListColumn(
    tasks: List<Task>,
    callbackChangeStatus: (Task, Boolean) -> Unit,
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
                isChecked = taskItem.checked,
                callbackChecked = { checked -> callbackChangeStatus(taskItem, checked) },
            )
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview(showBackground = true)
@Composable
fun ItemListColumnPreview() {
    val tasks = listOf<Task>(
        Task(id = 1, text = "Finish the App", description = "a lot of text", endDate = LocalDate.now()),
        Task(id = 2, text = "Learn compose", description = "a lot of text", endDate = LocalDate.now()),
        Task(id = 3, text = "make my first mobile app", description = "a lot of text", endDate = LocalDate.now()),
        Task(id = 4, text = "Became a senior developer", description = "a lot of text", endDate = LocalDate.now()),
    )

    ItemListColumn(
        tasks = tasks,
        callbackChangeStatus = { tasks, checked -> true },
    )
}