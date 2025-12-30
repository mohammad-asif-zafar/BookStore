package com.hathway.bookstore.screen

import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.hathway.bookstore.util.BottomNavItem
import com.hathway.bookstore.util.Routes

@Composable
fun BottomBar(navController: NavHostController,) {

    val items = listOf(
        BottomNavItem.Home, BottomNavItem.Search, BottomNavItem.Profile, BottomNavItem.Setting
    )

    NavigationBar {
        val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route

        items.forEach { item ->
            NavigationBarItem(
                selected = currentRoute == item.route, onClick = {
                navController.navigate(route = item.route) {
                    popUpTo(route = Routes.HOME) { saveState = true }
                    launchSingleTop = true
                    restoreState = true
                }
            }, icon = {
                BadgedBox(
                    badge = {
                        Badge()

                    }) {
                    Icon(
                        imageVector = item.icon, contentDescription = item.title
                    )
                }
            }, label = { Text(text = item.title) }, colors = NavigationBarItemDefaults.colors(
                selectedIconColor = MaterialTheme.colorScheme.primary,
                unselectedIconColor = MaterialTheme.colorScheme.onSurfaceVariant,
                selectedTextColor = MaterialTheme.colorScheme.primary,
                unselectedTextColor = MaterialTheme.colorScheme.onSurfaceVariant,
                indicatorColor = MaterialTheme.colorScheme.secondaryContainer
            )
            )

        }
    }
}
