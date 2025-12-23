package com.example.first_movile_app.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.first_movile_app.viewModel.SettingsViewModel
import com.example.first_movile_app.viewModel.ViewModalContainer


@Composable
fun AccountSettingsScreen(
    isDarkTheme: Boolean,
    onToggleTheme: () -> Unit,
) {

    Column(modifier = Modifier.fillMaxWidth()) {
        Text("Personalize your settings")

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = if (isDarkTheme) "Modo oscuro" else "Modo claro",
                modifier = Modifier.weight(1f)
            )
            Switch(
                checked = isDarkTheme,
                onCheckedChange = { onToggleTheme() }
            )
        }
    }
}
