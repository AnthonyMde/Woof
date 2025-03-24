package com.example.woof.app.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.woof.ui.theme.screens.CameraScreen
import com.example.woof.ui.theme.screens.HomeScreen
import com.example.woof.ui.theme.screens.ProfileScreen

@Composable
fun AppNavHost(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Route.Home
    ) {
        composable<Route.Home> {
            HomeScreen()
        }
        composable<Route.Camera> {
            CameraScreen()
        }
        composable<Route.Profile> {
            ProfileScreen()
        }
    }
}
