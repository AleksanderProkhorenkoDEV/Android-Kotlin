package com.example.first_movile_app.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector


sealed class TaskDestination(
    val route: String,
    val title: String,
    val icon: ImageVector
) {
    object TaskList : TaskDestination("taskList", "ToDo List", Icons.Default.Home)
    object CreateTask : TaskDestination("createTask", "Create new Task", Icons.Default.AddCircle)
    object AccountSettings : TaskDestination("accountSettings", "Settings", Icons.Default.Settings)

    object EditTask: TaskDestination("editTask/{id}", "Edit category", Icons.Default.Edit)
}

val taskDestinationBottomBar = listOf(
    TaskDestination.TaskList,
    TaskDestination.CreateTask,
    TaskDestination.AccountSettings
)