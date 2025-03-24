package com.example.woof.app.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.ui.features.ProfileScreen
import com.example.ui.features.camera.CameraScreenRoot
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
            CameraScreenRoot(
                goBackHome = {
                    navController.navigate(Route.Home) {
                        popUpTo<Route.Home> {
                            inclusive = true
                        }
                    }
                }
            )
        }
        composable<Route.Profile> {
            ProfileScreen()
        }
    }
}
