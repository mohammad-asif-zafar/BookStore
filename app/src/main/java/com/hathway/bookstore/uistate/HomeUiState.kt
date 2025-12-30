package com.hathway.bookstore.uistate

import com.hathway.bookstore.data.BookingCourseUiModel
import com.hathway.bookstore.data.CourseUiModel
import com.hathway.bookstore.data.TrendingCourseUiModel

sealed interface HighlightUiState {
    object Loading : HighlightUiState
    data class Success(val courses: List<CourseUiModel>) : HighlightUiState
    data class Error(val message: String) : HighlightUiState
}

sealed interface BookingUiState {
    object Loading : BookingUiState
    data class Success(val courses: List<BookingCourseUiModel>) : BookingUiState
    data class Error(val message: String) : BookingUiState
}

sealed interface TrendingUiState {
    object Loading : TrendingUiState
    data class Success(val courses: List<TrendingCourseUiModel>) : TrendingUiState
    data class Error(val message: String) : TrendingUiState
}