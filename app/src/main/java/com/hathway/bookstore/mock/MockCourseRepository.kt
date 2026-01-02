package com.hathway.bookstore.mock

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.EmojiEvents
import androidx.compose.material.icons.outlined.PersonSearch
import com.hathway.bookstore.R
import com.hathway.bookstore.data.BookingCourseUiModel
import com.hathway.bookstore.data.CourseUiModel
import com.hathway.bookstore.data.TrendingCourseUiModel
import com.hathway.bookstore.repo.CourseRepository
import com.hathway.bookstore.ui.theme.Double_Light_Grey
import com.hathway.bookstore.ui.theme.ErrorRed
import com.hathway.bookstore.ui.theme.GreenAccent
import com.hathway.bookstore.ui.theme.Grey
import com.hathway.bookstore.ui.theme.Light_Grey
import com.hathway.bookstore.ui.theme.OnLight

class MockCourseRepository : CourseRepository {

    override suspend fun getCourses(): List<CourseUiModel> {
        return listOf(
            CourseUiModel(
                id = 1,
                title = "Foundations of UX Design",
                subtitle = "Marsh Hove • 520k+ learners",
                meta = "6 Modules • 19h 59m",
                imageRes = R.drawable.boy,
                backgroundColor = R.color.Green
            ), CourseUiModel(
                id = 2,
                title = "UI Design Essentials",
                subtitle = "Alex Grant • 310k+ learners",
                meta = "5 Modules • 15h 20m",
                imageRes = R.drawable.girl,
                backgroundColor = R.color.Light_Grey
            ), CourseUiModel(
                id = 3,
                title = "Design Systems in Practice",
                subtitle = "Google UX Team • 180k+ learners",
                meta = "4 Modules • 12h 10m",
                imageRes = R.drawable.boy,
                backgroundColor = R.color.Green
            ), CourseUiModel(
                id = 4,
                title = "Mobile App UX Patterns",
                subtitle = "Sarah Lee • 275k+ learners",
                meta = "6 Modules • 16h 45m",
                imageRes = R.drawable.girl,
                backgroundColor = R.color.Light_Grey
            ), CourseUiModel(
                id = 5,
                title = "Interaction Design Basics",
                subtitle = "IDEO Academy • 410k+ learners",
                meta = "5 Modules • 14h 30m",
                imageRes = R.drawable.boy,
                backgroundColor = R.color.Green
            ), CourseUiModel(
                id = 6,
                title = "UX Research Fundamentals",
                subtitle = "Nielsen Norman Group • 350k+ learners",
                meta = "7 Modules • 18h 05m",
                imageRes = R.drawable.girl,
                backgroundColor = R.color.Light_Grey
            )
        )
    }

    override suspend fun getBookingCourses(): List<BookingCourseUiModel> {
        return listOf(
            BookingCourseUiModel(
                id = 1,
                title = "Mastering of graphic Design",
                price = "$499.00",
                imageRes = R.drawable.boy,
                imageBackground = OnLight
            ), BookingCourseUiModel(
                id = 2,
                title = "Graphic Design Principles",
                price = "$399.0",
                imageRes = R.drawable.girl,
                imageBackground = Light_Grey
            ), BookingCourseUiModel(
                id = 3,
                title = "UX Design Fundamentals",
                price = "$299.00",
                imageRes = R.drawable.boy,
                imageBackground = Double_Light_Grey
            ), BookingCourseUiModel(
                id = 4,
                title = "UI/UX Design Principles",
                price = "$349.00",
                imageRes = R.drawable.girl,
                imageBackground = Light_Grey
            ), BookingCourseUiModel(
                id = 5,
                title = "UX Research Techniques",
                price = "$249",
                imageRes = R.drawable.boy,
                imageBackground = OnLight
            ), BookingCourseUiModel(
                id = 6,
                title = "User Experience Design",
                price = "$39",
                imageRes = R.drawable.girl,
                imageBackground = GreenAccent
            )
        )
    }

    override suspend fun getTrendingCourses(): List<TrendingCourseUiModel> {
        return listOf(
            TrendingCourseUiModel(
                id = 1,
                name = "ux",
                title = "UX Design",
                icon = Icons.Outlined.PersonSearch,
                backgroundColor = GreenAccent
            ), TrendingCourseUiModel(
                id = 2,
                name = "ui",
                title = "UI Design",
                icon = Icons.Outlined.EmojiEvents,
                backgroundColor = Grey
            ), TrendingCourseUiModel(
                id = 3,
                name = "research",
                title = "UX Research",
                icon = Icons.Outlined.PersonSearch,
                backgroundColor = ErrorRed
            ), TrendingCourseUiModel(
                id = 4,
                name = "graphic",
                title = "Graphic Design",
                icon = Icons.Outlined.EmojiEvents,
                backgroundColor = Light_Grey
            )
        )
    }
}