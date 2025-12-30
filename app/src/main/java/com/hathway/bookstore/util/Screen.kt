package com.hathway.bookstore.util

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.ShowChart
import androidx.compose.material.icons.outlined.Description
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Settings
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
        BottomNavItem(route = Routes.HOME, title = TitleScreenName.HOME, Icons.Outlined.Home)

    object Search : BottomNavItem(
        route = Routes.DETAILS, title = TitleScreenName.DETAILS, Icons.Outlined.Description
    )

    object Profile : BottomNavItem(
        route = Routes.PROFILE, title = TitleScreenName.PROFILE, Icons.AutoMirrored.Outlined.ShowChart
    )

    object Setting : BottomNavItem(
        route = Routes.SETTING, title = TitleScreenName.SETTING, Icons.Outlined.Settings
    )
}