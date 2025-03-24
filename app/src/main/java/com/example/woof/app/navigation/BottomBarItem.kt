package com.example.woof.app.navigation

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.ui.R

enum class BottomBarItem(
    @StringRes val title: Int,
    val icon: ImageVector,
    val route: Route
) {
    HOME(
        title = R.string.navigation_bar_home_title,
        icon = Icons.Default.Home,
        route = Route.Home
    ),
    CAMERA(
        title = R.string.navigation_bar_camera_title,
        icon = Icons.Default.PlayArrow,
        route = Route.Camera
    ),
    PROFILE(
        title = R.string.navigation_bar_profile_title,
        icon = Icons.Default.Face,
        route = Route.Profile
    )
}
