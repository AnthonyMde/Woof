package com.example.woof.app.navigation.navigationbar

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.ui.R
import com.example.woof.app.navigation.Route

enum class NavigationBarItem(
    @StringRes val title: Int,
    @DrawableRes val icon: Int,
    val route: Route
) {
    HOME(
        title = R.string.navigation_bar_home_title,
        icon = R.drawable.ic_home_outlined,
        route = Route.Home
    ),
    CAMERA(
        title = R.string.navigation_bar_camera_title,
        icon = R.drawable.ic_camera_outlined,
        route = Route.Camera
    ),
    SHOP(
        title = R.string.navigation_bar_shop_title,
        icon = R.drawable.ic_shop_outlined,
        route = Route.Shop
    )
}
