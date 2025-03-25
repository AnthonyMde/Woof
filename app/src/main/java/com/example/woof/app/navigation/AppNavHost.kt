package com.example.woof.app.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.ui.features.ShopScreen
import com.example.ui.features.camera.CameraScreenRoot
import com.example.ui.features.comments.CommentScreenRoot
import com.example.ui.features.home.HomeScreenRoot
import com.example.ui.features.profile.ProfileScreenRoot

@Composable
fun AppNavHost(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Route.Home
    ) {
        composable<Route.Home> {
            HomeScreenRoot(
                goToUserProfile = { id ->
                    navController.navigate(Route.Profile(id))
                },
                goToCommentScreen = { publicationId ->
                    navController.navigate(Route.Comments(publicationId))
                }
            )
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

        composable<Route.Shop> {
            ShopScreen()
        }

        composable<Route.Profile>(
            enterTransition = {
                defaultEnterTransition()
            },
            popExitTransition = {
                defaultPopExitTransition()
            }
        ) { backStackEntry ->
            val userId = backStackEntry.arguments?.getString("userId") ?: return@composable

            ProfileScreenRoot(
                userId,
                navigateUp = {
                    navController.navigateUp()
                }
            )
        }

        composable<Route.Comments>(
            enterTransition = {
                defaultEnterTransition()
            },
            popExitTransition = {
                defaultPopExitTransition()
            }
        ) { backStackEntry ->
            val publicationId = backStackEntry.arguments?.getString("publicationId") ?: return@composable

            CommentScreenRoot(
                publicationId,
                navigateUp = {
                    navController.navigateUp()
                }
            )
        }
    }
}
