package com.example.basicstatecodelab.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.example.basicstatecodelab.component.WaterCounter
import com.example.basicstatecodelab.component.WellnessTaskList

@Composable
fun WellnessScreen(modifier: Modifier = Modifier) {
    var count by rememberSaveable { mutableIntStateOf(0) }
    Column(
        modifier = modifier
    ) {
        WaterCounter(
            count,
            { count++ },
            modifier
        )
        WellnessTaskList()
    }
}