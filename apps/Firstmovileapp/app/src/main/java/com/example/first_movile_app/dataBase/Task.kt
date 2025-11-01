package com.example.first_movile_app.dataBase

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import java.time.LocalDate

class Task(val id: Long, var text: String, var description: String, var endDate: LocalDate, initialCheck: Boolean = false){
    var checked by mutableStateOf(initialCheck)
}