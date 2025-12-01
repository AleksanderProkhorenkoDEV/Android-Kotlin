package com.example.first_movile_app.ui.components

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.dropShadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.shadow.Shadow
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import com.example.first_movile_app.R
import com.example.first_movile_app.dataBase.entities.Task

@Composable
fun ItemTask(
    task: Task,
    isChecked: Boolean,
    onNavigateToEditScreen: (id: Int) -> Unit,
    callbackChecked: (Boolean) -> Unit,
    callbackToDelete: (task: Task) -> Unit,
    modifier: Modifier = Modifier
) {

    var isExpanded by rememberSaveable { mutableStateOf(false) }

    Column(
        modifier = modifier
            .padding(8.dp)
            .fillMaxWidth(1f)
            .animateContentSize()
            .background(
                color = colorResource(R.color.secondary),
                shape = RoundedCornerShape(8.dp)
            )
            .border(
                width = 1.dp,
                color = colorResource(R.color.outline),
                shape = RoundedCornerShape(8.dp)
            ),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            modifier = modifier
                .fillMaxWidth(1f),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = task.text,
                modifier = Modifier.padding(horizontal = 8.dp),
            )
            Row {
                CheckButton(isChecked, callbackChecked = callbackChecked)
                ExpandButton(isExpanded, callbackExpanded = { isExpanded = !isExpanded })
            }
        }
        if (isExpanded) {
            Column(
                modifier = Modifier
                    .padding(8.dp),
            ) {
                HorizontalDivider(
                    thickness = 2.dp,
                    color = colorResource(R.color.outline)
                )
                Spacer(modifier = Modifier.padding(vertical = 4.dp))
                Text(
                    text = task.description,
                )
                Spacer(modifier = Modifier.padding(vertical = 4.dp))
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Button(
                        onClick = { onNavigateToEditScreen(task.id.toInt()) },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = colorResource(R.color.tertiary),
                            contentColor = colorResource(R.color.text_secondary)
                        )
                    ) {
                        Icon(
                            imageVector = Icons.Default.Edit,
                            contentDescription = stringResource(R.string.edit_task),
                            modifier = Modifier.size(16.dp)
                        )
                        Spacer(modifier = Modifier.padding(horizontal = 2.dp))
                        Text(
                            text = stringResource(R.string.edit_task),
                        )
                    }
                    Spacer(modifier = Modifier.padding(2.dp))
                    Button(
                        onClick = { callbackToDelete(task) },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = colorResource(R.color.accent_error),
                            contentColor = colorResource(R.color.text_primary)
                        )
                    ) {
                        Icon(
                            imageVector = Icons.Default.Delete,
                            contentDescription = stringResource(R.string.delete_task),
                            modifier = Modifier.size(16.dp)
                        )
                        Spacer(modifier = Modifier.padding(2.dp))
                        Text(text = stringResource(R.string.delete_task))

                    }
                }
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview(showBackground = true)
@Composable
fun ItemTaskPreview(
    modifier: Modifier = Modifier
) {
    val task = Task(5, "Exam", "Exam of Android, you will make a Task app", true)
    ItemTask(
        task = task,
        isChecked = true,
        onNavigateToEditScreen = {},
        callbackChecked = {},
        callbackToDelete = {},
        modifier = modifier
    )
}