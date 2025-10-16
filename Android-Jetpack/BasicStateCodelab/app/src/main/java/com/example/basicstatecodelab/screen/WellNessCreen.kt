package com.example.basicstatecodelab.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.basicstatecodelab.ViewModel.WellnessViewModel
import com.example.basicstatecodelab.component.WaterCounter
import com.example.basicstatecodelab.component.WellnessTaskList
import com.example.basicstatecodelab.model.WellnessTask

@Composable
fun WellnessScreen(
    modifier: Modifier = Modifier,
    wellnessViewModel: WellnessViewModel = viewModel()
) {
    var count by rememberSaveable { mutableIntStateOf(0) }

    Column(
        modifier = modifier
    ) {
        WaterCounter(
            count,
            { count++ },
            modifier
        )
        WellnessTaskList(
            list = wellnessViewModel.tasks,
            onCloseTask = { task -> wellnessViewModel.remove(task) },
            onCheckedTask = { task, checked -> wellnessViewModel.changeTaskChecked(task, checked) }
        )
    }
}

private fun getWellnessTasks() = List(30) { i -> WellnessTask(i, "Task # $i") }
