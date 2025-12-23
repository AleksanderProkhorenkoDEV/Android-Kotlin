package com.example.first_movile_app.ui.components.bars

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.first_movile_app.ui.components.buttons.ActionButton

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(
    title: String,
    showBackButton: Boolean,
    onNavigationBack: () -> Unit,
) {

    val shape = RoundedCornerShape(
        topStart = 0.dp,
        topEnd = 0.dp,
        bottomStart = 20.dp,
        bottomEnd = 20.dp
    )

    TopAppBar(
        title = { Text(title) },
        modifier = Modifier
            .shadow(elevation = 10.dp, shape = shape)
            .background(
                color = MaterialTheme.colorScheme.surface,
                shape = shape
            )
            .fillMaxWidth(),
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
    TopBar(title = "Tareas", showBackButton = false, onNavigationBack = {})
}
