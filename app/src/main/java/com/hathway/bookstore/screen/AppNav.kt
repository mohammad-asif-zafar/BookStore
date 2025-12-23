package com.hathway.bookstore.screen

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.hathway.bookstore.util.Screen


@Composable
fun AppNav() {
    val navController = rememberNavController()

    NavHost(
        navController = navController, startDestination = Screen.Home, modifier = Modifier
    ) {
        composable<Screen.Home> {
            HomeScreen()
        }

        composable<Screen.Profile> {
            ProfileScreen(
                )
        }

        composable<Screen.Details> { backStackEntry ->

            DetailsScreen(
                )
        }

        composable<Screen.Setting> {
            SettingScreen()
        }
    }
}
