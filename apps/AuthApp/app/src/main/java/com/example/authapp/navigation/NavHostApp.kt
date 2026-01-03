package com.example.authapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.authapp.ui.theme.screens.privates.DashboardScreen
import com.example.authapp.ui.theme.screens.privates.ProfileScreen
import com.example.authapp.ui.theme.screens.publics.ForgotPasswordScreen
import com.example.authapp.ui.theme.screens.publics.LoginScreen
import com.example.authapp.ui.theme.screens.publics.RegisterScreen

@Composable
fun NavHostApp(navController: NavHostController, modifier: Modifier) {
    NavHost(
        navController = navController,
        startDestination = Login,
        modifier = modifier
    ) {
        composable<Login> {
            LoginScreen(
                callbackNavigationToRegister = { navController.navigate(route = Register) },
                callbackNavigationToForgotPassword = { navController.navigate(route = ForgotPassword) }
            )
        }
        composable<Register> {
            RegisterScreen(
                callbackNavigationToLogin = { navController.navigate(route = Login) }
            )
        }
        composable<ForgotPassword> {
            ForgotPasswordScreen(
                callbackNavigationBack = { navController.popBackStack() }
            )

        }
        composable<Dashboard> {
            DashboardScreen()
        }
        composable<Profile> {
            ProfileScreen()
        }
    }
}