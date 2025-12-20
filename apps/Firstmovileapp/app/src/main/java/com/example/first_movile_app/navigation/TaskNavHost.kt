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
    viewModel: TopAppBarViewModel = viewModel(factory = ViewModalContainer.Factory)
) {
    NavHost(
        navController = navController,
        startDestination = TaskList,
        modifier = modifier,
    ) {
        composable<TaskList> {
            viewModel.setTitle(stringResource(R.string.app_name))
            MainScreen(onNavigateToEditScreen = { id ->
                navController.navigate(EditTask(id = id))
            })
        }
        composable<CreateTask> {
            viewModel.setTitle(stringResource(R.string.create_task_title_form))
            CreateTaskScreen(
                onNavigationBack = {
                    navController.popBackStack()
                },
                onNavigationList = {
                    navController.navigate(TaskList)
                })
        }
        composable<AccountSettings> {
            viewModel.setTitle(stringResource(R.string.setting_page))
            AccountSettingsScreen(onNavigationBack = {
                navController.popBackStack()
            })
        }

        composable<EditTask> { backStackEntry ->
            viewModel.setTitle(stringResource(R.string.edit_task))
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
