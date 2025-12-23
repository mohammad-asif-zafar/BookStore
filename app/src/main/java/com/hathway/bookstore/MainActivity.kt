package com.hathway.bookstore

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.hathway.bookstore.screen.BottomBar
import com.hathway.bookstore.screen.DetailsScreen
import com.hathway.bookstore.screen.HomeScreen
import com.hathway.bookstore.screen.ProfileScreen
import com.hathway.bookstore.screen.SettingScreen
import com.hathway.bookstore.ui.theme.BookStoreTheme
import com.hathway.bookstore.util.Routes

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BookStoreTheme {
                val navController = rememberNavController()
                Scaffold(
                    bottomBar = { BottomBar(navController) }) { padding ->

                    NavHost(
                        navController = navController,
                        startDestination = Routes.HOME,
                        modifier = Modifier.padding(paddingValues = padding)
                    ) {
                        composable(route = Routes.HOME) { HomeScreen() }
                        composable(route = Routes.DETAILS) { DetailsScreen() }
                        composable(route = Routes.PROFILE) { ProfileScreen() }
                        composable(route = Routes.SETTING) { SettingScreen() }
                    }
                }
            }
        }
    }
}



