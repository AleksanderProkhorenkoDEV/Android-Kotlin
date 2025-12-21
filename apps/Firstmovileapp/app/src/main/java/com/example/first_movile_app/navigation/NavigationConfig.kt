package com.example.first_movile_app.navigation

import kotlin.reflect.KClass

val TopLevelRoutes: Set<KClass<*>> = setOf(
    TaskList::class,
)

fun String?.isTopLevelRoute(): Boolean {
    if(this == null) return false

    return TopLevelRoutes.any() {routeClass ->
        this.contains(routeClass.simpleName.toString())
    }
}