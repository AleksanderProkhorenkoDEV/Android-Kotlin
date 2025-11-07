package com.example.first_movile_app.navigation


sealed class TaskDestination(
    val route: String,
    val title: String
) {
    object TaskList : TaskDestination("task_list", "ToDo List")
    object CreateTask : TaskDestination("create_task", "Create new Task")
}
