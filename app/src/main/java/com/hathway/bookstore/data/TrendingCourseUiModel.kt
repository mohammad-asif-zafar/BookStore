package com.hathway.bookstore.data

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.PersonSearch
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector

data class TrendingCourseUiModel(
    val id: Int = 0,
    val name: String = "",
    val title: String = "",
    val icon: ImageVector = Icons.Outlined.PersonSearch,
    val backgroundColor: Color = Color.White,
    val textColor: Color = Color.Black,
    val iconTint: Color = Color.Black
)