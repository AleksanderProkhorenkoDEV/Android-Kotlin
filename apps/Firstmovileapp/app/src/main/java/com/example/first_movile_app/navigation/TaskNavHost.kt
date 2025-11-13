package com.example.first_movile_app.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.example.first_movile_app.ui.screen.AccountSettingsScreen
import com.example.first_movile_app.ui.screen.CreateTaskScreen
import com.example.first_movile_app.ui.screen.EditTaskScreen
import com.example.first_movile_app.ui.screen.MainScreen
import kotlinx.serialization.Serializable

@Serializable
object Home
@Serializable
object Settings
@Serializable
object CreateTask
@Serializable
data class EditTask(val id: Int)

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun TaskNavHost(
    navController: NavHostController,
    modifier: Modifier
) {
    NavHost(
        navController = navController,
        startDestination = Home,
        modifier = modifier,
    ) {
        composable<Home> {
            MainScreen()
        }
        composable<CreateTask> {
            CreateTaskScreen()
        }
        composable<Settings> {
            AccountSettingsScreen()
        }

        composable<TaskDestination.EditTask>{ backStackEntry ->
            val params = backStackEntry.toRoute<EditTask>()
            EditTaskScreen(id = params.id)
        }
    }
}
