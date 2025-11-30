package com.example.first_movile_app

import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.navigation.compose.rememberNavController
import com.example.first_movile_app.ui.theme.FirstmovileappTheme
import com.example.first_movile_app.navigation.TaskNavHost
import com.example.first_movile_app.navigation.taskDestinationBottomBar
import com.example.first_movile_app.ui.components.BottomBar

@RequiresApi(Build.VERSION_CODES.O)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun TaskApp() {
    FirstmovileappTheme {
        val navController = rememberNavController()
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            bottomBar = {
                BottomBar(
                    allScreens = taskDestinationBottomBar,
                    onBottomSelected = { newScreen ->
                        navController.navigate(route = newScreen.route){
                            launchSingleTop = true
                        }
                    }
                )
            },
            containerColor = colorResource(R.color.dark_primary),
            contentColor = colorResource(R.color.text_primary)
        ) { innerPadding ->
            TaskNavHost(
                navController = navController,
                modifier = Modifier.padding(innerPadding)
            )
        }
    }
}