package com.example.woof.app.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.ui.features.CameraScreen
import com.example.ui.features.ProfileScreen
import com.example.ui.features.home.HomeScreenRoot

@Composable
fun AppNavHost(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Route.Home
    ) {
        composable<Route.Home> {
            HomeScreenRoot()
        }
        composable<Route.Camera> {
            CameraScreen()
        }
        composable<Route.Profile> {
            ProfileScreen()
        }
    }
}
