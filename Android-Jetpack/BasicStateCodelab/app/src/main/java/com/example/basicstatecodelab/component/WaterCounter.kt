package com.example.basicstatecodelab.component

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.basicstatecodelab.R

@Composable
fun WaterCounter (modifier: Modifier = Modifier){
    val count: Int = 0
    Text(
        text = stringResource(R.string.water_counter_text, count),
        modifier = modifier.padding(16.dp)
    )
}