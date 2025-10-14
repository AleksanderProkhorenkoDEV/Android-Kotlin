package com.example.basicstatecodelab.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.basicstatecodelab.R

@Composable
fun WaterCounter(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.padding(16.dp, top = 24.dp)
    ) {
        var count by remember { mutableIntStateOf(0) }

        if (count > 0) {
            var showTask by remember { mutableStateOf(true) }
            if (showTask) {
                WellnessTaskItem(
                    onClose = { showTask = false },
                    taskName = stringResource(R.string.walk_today_question)
                )
            }
        }

        Text(
            text = stringResource(R.string.water_counter_text, count),
        )
        Row(
            modifier = Modifier.padding(top = 8.dp)
        ) {
            Button(
                onClick = { count++ },
                modifier = Modifier.padding(8.dp),
                enabled = count < 10
            ) {
                Text(
                    text = stringResource(R.string.add_water),
                    modifier = Modifier.padding(8.dp)
                )
            }
            Button(
                onClick = { count = 0 },
                modifier = Modifier.padding(8.dp),
                enabled = count < 10
            ) {
                Text(
                    text = stringResource(R.string.clear_water),
                    modifier = Modifier.padding(8.dp)
                )
            }
        }
    }
}