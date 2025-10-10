package com.example.basicstatecodelab.screen

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.basicstatecodelab.component.WaterCounter

@Composable
fun WellnessScreen(modifier: Modifier = Modifier){
    WaterCounter(modifier)
}