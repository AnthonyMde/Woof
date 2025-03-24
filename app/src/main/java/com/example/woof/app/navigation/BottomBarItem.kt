package com.example.woof.app.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.ui.graphics.vector.ImageVector

enum class BottomBarItem(
    val title: String,
    val icon: ImageVector,
    val route: Route
) {
    HOME(
        title = "Home",
        icon = Icons.Default.Home,
        route = Route.Home
    ),
    CAMERA(
        title = "Camera",
        icon = Icons.Default.PlayArrow,
        route = Route.Camera
    ),
    PROFILE(
        title = "Home",
        icon = Icons.Default.Face,
        route = Route.Profile
    )
}
