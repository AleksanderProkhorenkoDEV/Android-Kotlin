package com.example.first_movile_app.ui.components.bars

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.first_movile_app.R
import com.example.first_movile_app.navigation.TaskDestination
import com.example.first_movile_app.navigation.taskDestinationBottomBar

@Composable
fun BottomBar(
    allScreens: List<TaskDestination>,
    onBottomSelected: (TaskDestination) -> Unit,
    modifier: Modifier = Modifier
) {

    val shape = RoundedCornerShape(
        topStart = 20.dp,
        topEnd = 20.dp,
        bottomStart = 0.dp,
        bottomEnd = 0.dp
    )

    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(68.dp)
            .shadow(elevation = 10.dp, shape = shape)
            .background(
                color = colorResource(R.color.surface),
                shape = shape,
            ),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
    ) {
        allScreens.forEach { screen ->
            IconButton(
                onClick = { onBottomSelected(screen) }
            ) {
                Icon(
                    imageVector = screen.icon,
                    contentDescription = screen.title,
                    tint = colorResource(R.color.text_primary)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BottomBarPreview() {
    BottomBar(allScreens = taskDestinationBottomBar, {})
}