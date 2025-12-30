package com.hathway.bookstore.data

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector

data class TrendingCourseUiModel(
    val id: String,
    val title: String,
    val icon: ImageVector,
    val backgroundColor: Color,
    val textColor: Color = Color.Black,
    val iconTint: Color = Color.Black
)