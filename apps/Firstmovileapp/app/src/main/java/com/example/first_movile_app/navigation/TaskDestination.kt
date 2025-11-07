package com.example.first_movile_app.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector


sealed class TaskDestination(
    val route: String,
    val title: String,
    val icon: ImageVector
) {
    object TaskList : TaskDestination("task_list", "ToDo List", Icons.Default.Home)
    object CreateTask : TaskDestination("create_task", "Create new Task", Icons.Default.AddCircle)
    object AccountSettings : TaskDestination("account_settings", "Settings", Icons.Default.Settings)
}

val taskDestinationBottomBar = listOf(
    TaskDestination.TaskList,
    TaskDestination.CreateTask,
    TaskDestination.AccountSettings
)