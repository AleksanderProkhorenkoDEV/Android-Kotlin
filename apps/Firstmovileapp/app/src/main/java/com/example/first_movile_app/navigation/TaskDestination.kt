package com.example.first_movile_app.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector
import kotlinx.serialization.Serializable

@Serializable
object TaskList
@Serializable
object CreateTask
@Serializable
object AccountSettings

@Serializable
data class EditTask(val id: Int)

data class TaskDestination(
    val route: Any,
    val title: String,
    val icon: ImageVector
) {
}

val taskDestinationBottomBar = listOf(
    TaskDestination(TaskList, "Task list", Icons.Default.Home),
    TaskDestination(CreateTask, "Create task", Icons.Default.AddCircle),
    TaskDestination(AccountSettings, "Settings", Icons.Default.Edit)
)