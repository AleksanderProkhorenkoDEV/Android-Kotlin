package com.example.first_movile_app.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.first_movile_app.navigation.TaskDestination
import com.example.first_movile_app.navigation.taskDestinationBottomBar

@Composable
fun BottomBar(
    allScreens: List<TaskDestination>,
    onBottomSelected: (TaskDestination) -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
    ) {
        allScreens.forEach { screen ->
            IconButton(
                onClick = { onBottomSelected(screen) }
            ) {
                Icon(
                    imageVector = screen.icon,
                    contentDescription = screen.title
                )
            }
        }
    }
}

@Preview
@Composable
fun BottomBarPreview() {
    BottomBar(allScreens = taskDestinationBottomBar, {})
}