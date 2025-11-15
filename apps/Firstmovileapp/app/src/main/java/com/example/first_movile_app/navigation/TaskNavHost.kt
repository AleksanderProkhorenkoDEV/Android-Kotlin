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

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun TaskNavHost(
    navController: NavHostController,
    modifier: Modifier
) {
    NavHost(
        navController = navController,
        startDestination = TaskList,
        modifier = modifier,
    ) {
        composable<TaskList> {
            MainScreen( onNavigateToEditScreen = { id ->
                navController.navigate(EditTask(id = id))
            })
        }
        composable<CreateTask> {
            CreateTaskScreen()
        }
        composable<AccountSettings> {
            AccountSettingsScreen()
        }

        composable<EditTask>{ backStackEntry ->
            val params = backStackEntry.toRoute<EditTask>()
            EditTaskScreen(id = params.id)
        }
    }
}
