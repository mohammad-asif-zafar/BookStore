package com.hathway.bookstore

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation3.compose.NavHost
import androidx.navigation3.compose.rememberNavController
import androidx.navigation3.compose.composable
import com.hathway.bookstore.screen.DetailsScreen
import com.hathway.bookstore.screen.HomeScreen
import com.hathway.bookstore.screen.ProfileScreen
import com.hathway.bookstore.ui.theme.BookStoreTheme
import com.hathway.bookstore.util.Screen

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BookStoreTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.Home,
        modifier = modifier
    ) {

        composable<Screen.Home> {
            HomeScreen(
                onProfileClick = {
                    navController.navigate(Screen.Profile)
                },
                onDetailsClick = { id ->
                    navController.navigate(Screen.Details(id))
                }
            )
        }

        composable<Screen.Profile> {
            ProfileScreen(
                onBack = {
                    navController.popBackStack()
                }
            )
        }

        composable<Screen.Details> { backStackEntry ->
            val details: Screen.Details = backStackEntry.toRoute()
            DetailsScreen(
                userId = details.userId,
                onBack = {
                    navController.popBackStack()
                }
            )
        }
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BookStoreTheme {
        Greeting("Android")
    }

}