package com.hathway.bookstore.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.outlined.EmojiEvents
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.hathway.bookstore.R
import com.hathway.bookstore.components.CapsuleIconButton
import com.hathway.bookstore.components.CourseBookingCard
import com.hathway.bookstore.components.CourseHighlightCard
import com.hathway.bookstore.components.SearchToolbar
import com.hathway.bookstore.components.ToolBar
import com.hathway.bookstore.mock.MockCourseRepository
import com.hathway.bookstore.repo.HomeViewModelFactory
import com.hathway.bookstore.uistate.BookingUiState
import com.hathway.bookstore.uistate.HighlightUiState
import com.hathway.bookstore.uistate.TrendingUiState
import com.hathway.bookstore.viewmodel.HomeViewModel

@Composable
fun HomeScreen(

) {
    val repository = remember { MockCourseRepository() }

    val viewModel: HomeViewModel = viewModel(factory = HomeViewModelFactory(repository))

    val highlightState by viewModel.highlightState.collectAsState()
    val bookingState by viewModel.bookingState.collectAsState()
    val trendingState by viewModel.trendingState.collectAsState()

    Column {
        ToolBar(
            modifier = Modifier.fillMaxWidth(),

            // ⬅️ Back button
            backEnable = false,
            onBackClick = {
                println("Back clicked")
            },
            backIcon = Icons.AutoMirrored.Filled.ArrowBack,
            backIconTint = Color.Black,
            backGroundColor = Color.Transparent,
            backBorder = 1.dp,
            backBorderColor = Color.Gray,
            backElevation = 4.dp,

            // 🏷 Title
            title = stringResource(R.string.learnify),
            titleColor = Color.Black,
            titleSize = 24.sp,
            titleWeight = FontWeight.Medium,
            titleAlignment = Alignment.Start, // (note: not used in Row)

            // 🏆 Middle icon (Leaderboard)
            middleEnable = true,
            onMiddleClick = {
                println("Leaderboard clicked")
            },
            middleIcon = Icons.Outlined.EmojiEvents,
            middleIconTint = Color.Black,
            middleGroundColor = Color.Transparent,
            middleElevation = 4.dp,
            middleBorder = 1.dp,
            middleBorderColor = Color.Gray,

            // 🔔 End icon (Notifications)
            endEnable = true,
            onEndClick = {
                println("Notifications clicked")
            },
            endIcon = Icons.Outlined.Notifications,
            endIconTint = Color.Black,
            endGroundColor = Color.Transparent,
            endBorder = 1.dp,
            endBorderColor = Color.Gray,
            endElevation = 4.dp
        )

        Column(modifier = Modifier.padding(start = 10.dp, end = 10.dp, top = 2.dp)) {

            Spacer(modifier = Modifier.height(8.dp))

            when (trendingState) {
                is TrendingUiState.Loading -> {
                    // shimmer
                }

                is TrendingUiState.Success -> {
                    val courses = (trendingState as TrendingUiState.Success).courses
                    LazyRow(
                        modifier = Modifier.fillMaxWidth(),
                        contentPadding = PaddingValues(horizontal = 8.dp),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        items(items = courses, key = { it.id } // ✅ stable key
                        ) { item ->
                            CapsuleIconButton(
                                onClick = { },   // ✅ no index
                                icon = item.icon,                  // ✅ from model
                                text = item.title,                 // ✅ from model
                                iconTint = item.iconTint,
                                backgroundColor = item.backgroundColor,
                                textColor = item.textColor,
                                iconEnable = true
                            )
                        }
                    }

                }

                is TrendingUiState.Error -> {
                    Text("Failed to load bookings")
                }
            }
            Spacer(modifier = Modifier.height(8.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 10.dp, end = 10.dp, top = 2.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Continue learning", style = MaterialTheme.typography.titleLarge.copy(
                        fontWeight = FontWeight.Medium
                    ), color = Color.Black
                )
                Spacer(modifier = Modifier.weight(1f)) // 🚀 pushes icon to right

                Text(
                    text = "View all",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurface
                )

                Icon(
                    imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                    contentDescription = "View all",
                    tint = MaterialTheme.colorScheme.onSurface
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            // 🔹 Highlight section
            when (highlightState) {
                is HighlightUiState.Loading -> {
                    // shimmer
                }

                is HighlightUiState.Success -> {
                    val courses = (highlightState as HighlightUiState.Success).courses

                    LazyRow {
                        items(courses) {
                            CourseHighlightCard(course = it)
                        }
                    }
                }

                is HighlightUiState.Error -> {
                    Text("Failed to load highlights")
                }
            }

            Spacer(modifier = Modifier.height(8.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 10.dp, end = 10.dp, top = 2.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Popular 1-on-1 Sessions",
                    style = MaterialTheme.typography.titleLarge.copy(
                        fontWeight = FontWeight.Medium
                    ),
                    color = Color.Black
                )
                Spacer(modifier = Modifier.weight(1f)) // 🚀 pushes icon to right

                Text(
                    text = "View all",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurface
                )

                Icon(
                    imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                    contentDescription = "View all",
                    tint = MaterialTheme.colorScheme.onSurface
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            // 🔹 Booking section
            when (bookingState) {
                is BookingUiState.Loading -> {
                    // shimmer
                }

                is BookingUiState.Success -> {
                    val courses = (bookingState as BookingUiState.Success).courses

                    LazyRow {
                        items(courses) {
                            CourseBookingCard(course = it)
                        }
                    }
                }

                is BookingUiState.Error -> {
                    Text("Failed to load bookings")
                }

                else -> {}
            }
        }
    }


}

@Preview
@Composable
private fun PreViewSearchToolbar() {
    SearchToolbar(modifier = Modifier, onProfileClick = {}, onSearchChange = {})
}
