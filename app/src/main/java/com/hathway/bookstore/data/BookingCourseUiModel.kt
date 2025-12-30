package com.hathway.bookstore.data

import androidx.compose.ui.graphics.Color

data class BookingCourseUiModel(
    val id: String = "",
    val title: String = "",
    val price: String = "",
    val imageRes: Int = 0,
    val imageBackground: Color = Color.White
)
