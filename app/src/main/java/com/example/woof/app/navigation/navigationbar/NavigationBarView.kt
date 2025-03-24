package com.example.woof.app.navigation.navigationbar

import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.util.fastForEach
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun NavigationBarView(
    navController: NavController
) {
    val currentBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = currentBackStackEntry?.destination?.route

    val showBottomBar: Boolean = NavigationBarItem.entries
        .map { it.route::class.qualifiedName }
        .contains(currentRoute)

    if (showBottomBar) {
        NavigationBar {
            NavigationBarItem.entries.fastForEach { item ->
                val isSelected = currentRoute == item.route::class.qualifiedName
                NavigationBarItem(
                    selected = isSelected,
                    onClick = {
                        // Clear the stack when switching between tabs avoiding useless history
                        // And multiple screens creation.
                        navController.navigate(item.route) {
                            launchSingleTop = true
                            popUpTo(navController.graph.startDestinationId) {
                                inclusive = false
                                saveState = true
                            }
                            restoreState = true
                        }
                    },
                    icon = {
                        Icon(
                            painter = painterResource(item.icon),
                            contentDescription = stringResource(item.title)
                        )
                    },
                    label = {
                        Text(
                            text = stringResource(item.title),
                            style = MaterialTheme.typography.labelMedium
                        )
                    }
                )
            }
        }
    }
}
