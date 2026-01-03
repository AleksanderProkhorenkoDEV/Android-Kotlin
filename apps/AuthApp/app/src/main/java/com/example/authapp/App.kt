package com.example.authapp

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.authapp.navigation.NavHostApp

@Composable
fun App(modifier: Modifier = Modifier){
    val navController = rememberNavController()
    NavHostApp(navController = navController, modifier = modifier)
}