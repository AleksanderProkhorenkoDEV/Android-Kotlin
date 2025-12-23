package com.example.first_movile_app

import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.first_movile_app.navigation.AccountSettings
import com.example.first_movile_app.navigation.CreateTask
import com.example.first_movile_app.navigation.EditTask
import com.example.first_movile_app.navigation.TaskList
import com.example.first_movile_app.ui.theme.FirstmovileappTheme
import com.example.first_movile_app.navigation.TaskNavHost
import com.example.first_movile_app.navigation.isTopLevelRoute
import com.example.first_movile_app.navigation.taskDestinationBottomBar
import com.example.first_movile_app.ui.components.bars.BottomBar
import com.example.first_movile_app.ui.components.bars.TopBar
import com.example.first_movile_app.viewModel.SettingsViewModel
import com.example.first_movile_app.viewModel.ViewModalContainer


@OptIn(ExperimentalMaterial3Api::class)
@RequiresApi(Build.VERSION_CODES.O)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun TaskApp(
    settingsViewModel: SettingsViewModel = viewModel(factory = ViewModalContainer.Factory)
) {
    val isDarkTheme by settingsViewModel.isDarkTheme.collectAsState()

    FirstmovileappTheme(
        darkTheme = isDarkTheme,
    ) {
        val navController = rememberNavController()
        //Get the state of navigation
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        val showBottomBar = currentRoute.isTopLevelRoute()

        val appBarState = remember(currentRoute) {
            val title = when {
                currentRoute?.contains(TaskList::class.simpleName.toString()) == true -> "Mis Tareas"
                currentRoute?.contains(AccountSettings::class.simpleName.toString()) == true -> "Ajustes"
                currentRoute?.contains(CreateTask::class.simpleName.toString()) == true -> "Crear Tarea"
                currentRoute?.contains(EditTask::class.simpleName.toString()) == true -> "Editar Tarea"
                else -> ""
            }
            val canNavigateBack =
                !currentRoute.isTopLevelRoute() && navController.previousBackStackEntry != null
            title to canNavigateBack
        }

        val (title) = appBarState
        val snackbar = remember { SnackbarHostState() }

        Scaffold(
            modifier = Modifier.fillMaxSize(),
            topBar = {
                TopBar(
                    title = title,
                    showBackButton = !currentRoute.isTopLevelRoute(),
                    onNavigationBack = { navController.popBackStack() }
                )
            },
            bottomBar = {
                if (showBottomBar) {
                    BottomBar(
                        allScreens = taskDestinationBottomBar,
                        onBottomSelected = { newScreen ->
                            navController.navigate(route = newScreen.route) {
                                launchSingleTop = true
                            }
                        }
                    )
                }
            },
            snackbarHost = {
                SnackbarHost(snackbar) { data ->
                    Snackbar(
                        snackbarData = data,
                        modifier = Modifier.padding(16.dp),
                        shape = RoundedCornerShape(8.dp),
                        containerColor = MaterialTheme.colorScheme.background,
                        contentColor = MaterialTheme.colorScheme.onBackground
                    )
                }
            },
            containerColor = MaterialTheme.colorScheme.surface,
        ) { innerPadding ->
            TaskNavHost(
                navController = navController,
                modifier = Modifier.padding(innerPadding),
                snackbarHostState = snackbar,
                onToggleTheme = { settingsViewModel.toggleTheme() },
                isDarkTheme = isDarkTheme
            )
        }
    }
}