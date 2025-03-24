package com.example.woof.app.navigation

import kotlinx.serialization.Serializable

sealed class Route {
    @Serializable
    data object Home : Route()
    @Serializable
    data object Camera : Route()
    @Serializable
    data object Shop : Route()
    @Serializable
    data class Profile(val userId: String) : Route()
}
