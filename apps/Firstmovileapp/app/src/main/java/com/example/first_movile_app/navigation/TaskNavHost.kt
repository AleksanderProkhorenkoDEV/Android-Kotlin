package com.example.first_movile_app.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.first_movile_app.ui.screen.AccountSettingsScreen
import com.example.first_movile_app.ui.screen.CreateTaskScreen
import com.example.first_movile_app.ui.screen.MainScreen

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun TaskNavHost(
    navController: NavHostController,
    modifier: Modifier
) {
    NavHost(
        navController = navController,
        startDestination = TaskDestination.TaskList.route,
        modifier = modifier,
    ) {
        composable(route = TaskDestination.TaskList.route) {
            MainScreen()
        }
        composable(route = TaskDestination.CreateTask.route) {
            CreateTaskScreen()
        }
        composable(route = TaskDestination.AccountSettings.route){
            AccountSettingsScreen()
        }
    }
}
