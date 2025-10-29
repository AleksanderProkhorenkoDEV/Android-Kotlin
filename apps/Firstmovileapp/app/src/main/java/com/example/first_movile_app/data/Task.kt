package com.example.first_movile_app.data

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

class Task(val id: Long, var text: String, initialCheck: Boolean = false){
    var checked by mutableStateOf(initialCheck)
}