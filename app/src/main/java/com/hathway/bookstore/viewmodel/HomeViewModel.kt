package com.hathway.bookstore.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hathway.bookstore.repo.CourseRepository
import com.hathway.bookstore.uistate.BookingUiState
import com.hathway.bookstore.uistate.HighlightUiState
import com.hathway.bookstore.uistate.TrendingUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class HomeViewModel(
    private val repository: CourseRepository
) : ViewModel() {

    private val _highlightState = MutableStateFlow<HighlightUiState>(HighlightUiState.Loading)
    val highlightState = _highlightState.asStateFlow()

    private val _bookingState = MutableStateFlow<BookingUiState>(BookingUiState.Loading)
    val bookingState = _bookingState.asStateFlow()

    private val _trendingState = MutableStateFlow<TrendingUiState>(TrendingUiState.Loading)
    val  trendingState = _trendingState.asStateFlow()

    init {
        loadHighlightCourses()
        loadBookingCourses()
        getTrendingCourses()
    }

    private fun loadHighlightCourses() {
        viewModelScope.launch {
            runCatching {
                repository.getCourses()
            }.onSuccess {
                _highlightState.value = HighlightUiState.Success(it)
            }.onFailure {
                _highlightState.value = HighlightUiState.Error("Failed to load highlight courses")
            }
        }
    }

    private fun loadBookingCourses() {
        viewModelScope.launch {
            runCatching {
                repository.getBookingCourses()
            }.onSuccess {
                print("ssss"+it.size)
                _bookingState.value = BookingUiState.Success(it)
            }.onFailure {
                _bookingState.value = BookingUiState.Error("Failed to load booking courses")
            }
        }
    }

    private fun getTrendingCourses() {
        viewModelScope.launch {
            runCatching {
                repository.getTrendingCourses()
            }.onSuccess {
                _trendingState.value = TrendingUiState.Success(it)
            }.onFailure {
                _trendingState.value = TrendingUiState.Error("Failed to load trending courses")
            }
        }
    }
}

