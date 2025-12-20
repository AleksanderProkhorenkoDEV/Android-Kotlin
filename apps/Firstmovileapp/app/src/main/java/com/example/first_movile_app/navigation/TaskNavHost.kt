package com.example.first_movile_app.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.first_movile_app.ui.screen.AccountSettingsScreen
import com.example.first_movile_app.ui.screen.CreateTaskScreen
import com.example.first_movile_app.ui.screen.EditTaskScreen
import com.example.first_movile_app.ui.screen.MainScreen
import com.example.first_movile_app.viewModel.TopAppBarViewModel
import com.example.first_movile_app.viewModel.ViewModalContainer
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.first_movile_app.R

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun TaskNavHost(
    navController: NavHostController,
    modifier: Modifier,
) {
    NavHost(
        navController = navController,
        startDestination = TaskList,
        modifier = modifier,
    ) {
        composable<TaskList> {
            MainScreen(onNavigateToEditScreen = { id ->
                navController.navigate(EditTask(id = id))
            })
        }
        composable<CreateTask> {
            CreateTaskScreen(
                onNavigationBack = {
                    navController.popBackStack()
                },
                onNavigationList = {
                    navController.navigate(TaskList)
                })
        }
        composable<AccountSettings> {
            AccountSettingsScreen(onNavigationBack = {
                navController.popBackStack()
            })
        }

        composable<EditTask> { backStackEntry ->
            EditTaskScreen(
                onNavigationBack = {
                    navController.popBackStack()
                },
                onNavigationList = {
                    navController.navigate(TaskList)
                })
        }
    }
}
