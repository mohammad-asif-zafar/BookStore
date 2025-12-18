package com.hathway.bookstore.util

import kotlinx.serialization.Serializable

sealed interface Screen {
    @Serializable
    data object Home : Screen

    @Serializable
    data object Profile : Screen

    @Serializable
    data class Details(val userId: Int) : Screen
}