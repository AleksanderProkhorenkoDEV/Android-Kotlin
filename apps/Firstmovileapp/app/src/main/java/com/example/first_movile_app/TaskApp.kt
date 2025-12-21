package com.example.first_movile_app

import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
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


@OptIn(ExperimentalMaterial3Api::class)
@RequiresApi(Build.VERSION_CODES.O)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun TaskApp() {
    FirstmovileappTheme {
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
                        containerColor = colorResource(R.color.secondary),
                        contentColor = colorResource(R.color.text_primary)
                    )
                }
            },
            containerColor = colorResource(R.color.surface),
        ) { innerPadding ->
            TaskNavHost(
                navController = navController,
                modifier = Modifier.padding(innerPadding),
                snackbarHostState = snackbar,
            )
        }
    }
}