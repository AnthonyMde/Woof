package com.example.woof.app.navigation

import kotlinx.serialization.Serializable

sealed interface Route {
    @Serializable
    data object Home : Route
    @Serializable
    data object Camera : Route
    @Serializable
    data object Profile : Route
}
