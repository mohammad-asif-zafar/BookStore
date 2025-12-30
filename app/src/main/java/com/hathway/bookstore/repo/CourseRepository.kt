package com.hathway.bookstore.repo

import com.hathway.bookstore.data.BookingCourseUiModel
import com.hathway.bookstore.data.CourseUiModel
import com.hathway.bookstore.data.TrendingCourseUiModel

interface CourseRepository {
    suspend fun getCourses(): List<CourseUiModel>
    suspend fun getBookingCourses(): List<BookingCourseUiModel>
    suspend fun getTrendingCourses(): List<TrendingCourseUiModel>
}