package com.example.first_movile_app

import android.annotation.SuppressLint
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.first_movile_app.navigation.AccountSettings
import com.example.first_movile_app.navigation.CreateTask
import com.example.first_movile_app.navigation.EditTask
import com.example.first_movile_app.navigation.TaskList
import com.example.first_movile_app.ui.theme.FirstmovileappTheme
import com.example.first_movile_app.navigation.TaskNavHost
import com.example.first_movile_app.navigation.taskDestinationBottomBar
import com.example.first_movile_app.ui.components.BottomBar

@OptIn(ExperimentalMaterial3Api::class)
@RequiresApi(Build.VERSION_CODES.O)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun TaskApp() {
    FirstmovileappTheme {
        val navController = rememberNavController()
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        val title = getTitleFromRoute(currentRoute)

        Log.d("INFO", "Current route: $currentRoute")
        Log.d("INFO", "title route: $title")


        Scaffold(
            modifier = Modifier.fillMaxSize(),
            topBar = {
                TopAppBar(
                    title = { Text(text = title) }
                )
            },
            bottomBar = {
                BottomBar(
                    allScreens = taskDestinationBottomBar,
                    onBottomSelected = { newScreen ->
                        navController.navigate(route = newScreen.route) {
                            launchSingleTop = true
                        }
                    }
                )
            },
            containerColor = colorResource(R.color.surface),
        ) { innerPadding ->
            TaskNavHost(
                navController = navController,
                modifier = Modifier.padding(innerPadding)
            )
        }
    }
}

private fun getTitleFromRoute(route: String?): String {
    return when {
        route == TaskList::class.simpleName?.lowercase() -> "Mis Tareas"
        route == CreateTask::class.simpleName?.lowercase() -> "Crear Tarea"
        route?.startsWith(EditTask::class.simpleName?.lowercase() ?: "") == true -> "Editar Tarea"
        route == AccountSettings::class.simpleName?.lowercase() -> "Ajustes"
        else -> "Task App"
    }
}