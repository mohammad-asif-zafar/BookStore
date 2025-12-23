package com.hathway.bookstore.screen

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.hathway.bookstore.util.BottomNavItem

@Composable
fun BottomBar(navController: NavHostController) {

    val items = listOf(
        BottomNavItem.Home, BottomNavItem.Search, BottomNavItem.Profile, BottomNavItem.Setting
    )

    NavigationBar {
        val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route

        items.forEach { item ->
            NavigationBarItem(selected = currentRoute == item.route, onClick = {
                navController.navigate(item.route) {
                    popUpTo("home") { saveState = true }
                    launchSingleTop = true
                    restoreState = true
                }
            }, icon = {
                Icon(imageVector = item.icon, contentDescription = item.title)
            }, label = { Text(item.title) })
        }
    }
}
