package com.example.first_movile_app.ui.components

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.first_movile_app.dataBase.entities.Task

@Composable
fun ItemTask(
    task: Task,
    isChecked: Boolean,
    callbackChecked: (Boolean) -> Unit,
    modifier: Modifier = Modifier
) {

    var isExpanded by rememberSaveable { mutableStateOf(false) }

    Column(
        modifier = modifier
            .padding(8.dp)
            .fillMaxWidth(1f)
            .animateContentSize()
            .shadow(
                elevation = 4.dp,
                shape = RoundedCornerShape(8.dp),
                clip = true
            )
            .background(
                color = MaterialTheme.colorScheme.surface,
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
        if(isExpanded){
            Column(
                modifier = Modifier
                            .padding(8.dp),
            ) {
                Text(task.description)
                Spacer(modifier = Modifier.height(8.dp))
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
    val task = Task(5, "Exam", "Exam of Android, you will make a Task app",  true)
    ItemTask(
        task = task,
        isChecked = true,
        callbackChecked = {},
        modifier = modifier
    )
}