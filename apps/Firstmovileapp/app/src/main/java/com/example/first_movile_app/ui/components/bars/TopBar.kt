package com.example.first_movile_app.ui.components.bars

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.first_movile_app.ui.components.buttons.ActionButton

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(
    title: String,
    showBackButton: Boolean,
    onNavigationBack: () -> Unit,
) {
    TopAppBar(
        title = { Text(title) },
        navigationIcon = {
            if (showBackButton) {
                ActionButton(
                    onClickAction = onNavigationBack,
                    icon = {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "go back"
                        )
                    }
                )
            }
        }
    )
}


@Preview()
@Composable
fun TopBarPreview() {
    TopBar(title = "Tareas", showBackButton = false ,onNavigationBack = {})
}
