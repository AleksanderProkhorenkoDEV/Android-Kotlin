package org.example

import kotlinx.coroutines.*
import kotlin.time.Duration.Companion.milliseconds
import kotlin.time.Duration.Companion.seconds

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
suspend fun main() {
    withContext(Dispatchers.Default) {
        this.launch { greet() }

        this.launch {
            println("Teh CoroutineScope.launch on the thread: ${Thread.currentThread().name}")
            delay(1.seconds)
        }

        println("The withContext() on the thread: ${Thread.currentThread().name}")
    }

    performBackgroundWork()
}

suspend fun greet() {
    println("The greet() on the thread: ${Thread.currentThread().name}")
    delay(1.seconds)
}

suspend fun performBackgroundWork() = coroutineScope {
    //That don't block the scope, make a new thread and execute the logic.
    this.launch {
        delay(100.milliseconds)
        println("Performing background work")
    }

    println("The scope continue")
}

