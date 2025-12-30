package com.hathway.bookstore.data

import androidx.compose.ui.graphics.Color

data class CourseUiModel(
    val id: String = "",
    val title: String = "",
    val subtitle: String = "",
    val meta: String = "",
    val imageRes: Int = 0,
    val backgroundColor: Int = 0
)
