package com.example.basicstatecodelab.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.basicstatecodelab.R

@Composable
fun WaterCounter(
    count: Int,
    onIncrement: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.padding(16.dp, top = 24.dp)
    ) {

        if (count > 0) {
            Text(
                text = stringResource(R.string.water_counter_text, count),
            )
        }

        Button(
            onClick = onIncrement,
            modifier = Modifier.padding(8.dp),
            enabled = count < 10
        ) {
            Text(
                text = stringResource(R.string.add_water),
                modifier = Modifier.padding(8.dp)
            )
        }


    }
}