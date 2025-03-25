package com.example.ui.navigation

import kotlinx.serialization.Serializable

sealed interface Route {
    @Serializable
    data object Home : Route

    @Serializable
    data object Camera : Route

    @Serializable
    data object Shop : Route

    @Serializable
    data class Profile(val userId: String) : Route

    @Serializable
    data class Comments(val publicationId: String) : Route
}
