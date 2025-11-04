package com.example.first_movile_app

import android.app.Application
import com.example.first_movile_app.di.AppDataContainer

class TaskApplication : Application() {
    val container by lazy { AppDataContainer(applicationContext) }
}