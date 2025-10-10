package com.example.basicstatecodelab.component

import androidx.compose.foundation.layout.Column
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

        Text(
            text = stringResource(R.string.water_counter_text, count),
        )
        Button(
            onClick = { count++ },
            modifier = Modifier.padding(8.dp)
        ) {
            Text(
                text = stringResource(R.string.add_water),
                modifier = modifier.padding(8.dp)
            )
        }
    }
}