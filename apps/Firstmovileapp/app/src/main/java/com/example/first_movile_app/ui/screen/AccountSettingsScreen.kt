package com.example.first_movile_app.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.first_movile_app.R

@Composable
fun AccountSettingsScreen (onNavigationBack: () -> Unit) {
    Scaffold(

    ) { innerPadding ->
        Column(
            modifier = Modifier.padding(innerPadding)
        ) {
            Text("Personalize your settings")
        }
    }
}