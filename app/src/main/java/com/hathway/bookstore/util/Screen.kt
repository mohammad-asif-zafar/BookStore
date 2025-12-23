package com.hathway.bookstore.util

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector

sealed interface Screen {
    data object Home : Screen
    data object Profile : Screen
    data object Details : Screen
    data object Setting : Screen
}

sealed class BottomNavItem(
    val route: String, val title: String, val icon: ImageVector
) {
    object Home :
        BottomNavItem(route = Routes.HOME, title = TitleScreenName.HOME, Icons.Default.Home)

    object Search :
        BottomNavItem(route = Routes.DETAILS, title = TitleScreenName.DETAILS, Icons.Default.Delete)

    object Profile :
        BottomNavItem(route = Routes.PROFILE, title = TitleScreenName.PROFILE, Icons.Default.Person)

    object Setting : BottomNavItem(
        route = Routes.SETTING, title = TitleScreenName.SETTING, Icons.Default.Settings
    )
}