package com.hathway.bookstore.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.EmojiEvents
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
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
import com.hathway.bookstore.components.SectionHeaderHome
import com.hathway.bookstore.components.ToolBar
import com.hathway.bookstore.data.CourseUiModel
import com.hathway.bookstore.mock.MockCourseRepository
import com.hathway.bookstore.repo.HomeViewModelFactory
import com.hathway.bookstore.ui.theme.Light_Grey
import com.hathway.bookstore.uistate.BookingUiState
import com.hathway.bookstore.uistate.HighlightUiState
import com.hathway.bookstore.uistate.TrendingUiState
import com.hathway.bookstore.viewmodel.HomeViewModel

@Composable
fun HomeScreen() {

    val repository = remember { MockCourseRepository() }
    val viewModel: HomeViewModel = viewModel(factory = HomeViewModelFactory(repository))

    val highlightState by viewModel.highlightState.collectAsState()
    val bookingState by viewModel.bookingState.collectAsState()
    val trendingState by viewModel.trendingState.collectAsState()

    LazyColumn(
        modifier = Modifier.fillMaxWidth(), contentPadding = PaddingValues(bottom = 16.dp)
    ) {

        // 🔹 Toolbar
        item {
            ToolBar(
                modifier = Modifier.fillMaxWidth(),
                backEnable = false,
                title = stringResource(R.string.learnify),
                titleSize = 24.sp,
                titleWeight = FontWeight.Medium,
                middleEnable = true,
                middleIcon = Icons.Outlined.EmojiEvents,
                endEnable = true,
                endIcon = Icons.Outlined.Notifications,
                onBackClick = { println("Back") },
                onMiddleClick = { println("Middle") },
                onEndClick = { println("End") }

            )
        }

        // 🔹 Trending section
        item {
            Spacer(modifier = Modifier.height(8.dp))

            when (trendingState) {
                is TrendingUiState.Success -> {
                    val courses = (trendingState as TrendingUiState.Success).courses

                    LazyRow(
                        contentPadding = PaddingValues(horizontal = 8.dp),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        items(courses, key = { it.id }) { item ->
                            CapsuleIconButton(
                                onClick = { println("Items $item ") },
                                icon = item.icon,
                                text = item.title,
                                iconTint = item.iconTint,
                                backgroundColor = item.backgroundColor,
                                textColor = item.textColor,
                                iconEnable = true
                            )
                        }
                    }
                }

                is TrendingUiState.Error -> {
                    Text("Failed to load trending")
                }

                else -> {}
            }
        }

        // 🔹 Continue learning
        item {
            Spacer(modifier = Modifier.height(16.dp))
            SectionHeaderHome(
                title = "Continue learning", onMoreClick = {
                    println("More")
                })
            Spacer(modifier = Modifier.height(8.dp))
        }

        // 🔹 Highlight cards
        item {
            when (highlightState) {
                is HighlightUiState.Success -> {
                    LazyRow(
                        contentPadding = PaddingValues(horizontal = 8.dp),
                        horizontalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        items(
                            (highlightState as HighlightUiState.Success).courses,
                            key = { it.title }) {
                            CourseHighlightCard(
                                course = it, onClick = { println("Hello $it") })
                        }
                    }
                }

                is HighlightUiState.Error -> {
                    Text("Failed to load highlights")
                }

                else -> {}
            }
        }

        // 🔹 Booking section
        item {
            Spacer(modifier = Modifier.height(16.dp))
            SectionHeaderHome(title = "Popular 1-on-1 Sessions", onMoreClick = {
                println("Sessions on click")
            })
            Spacer(modifier = Modifier.height(8.dp))

            when (bookingState) {
                is BookingUiState.Success -> {
                    LazyRow(
                        contentPadding = PaddingValues(horizontal = 8.dp),
                        horizontalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        items(
                            (bookingState as BookingUiState.Success).courses, key = { it.title }) {
                            CourseBookingCard(course = it,onBookClick = {println("Course book $it")})
                        }
                    }
                }

                is BookingUiState.Error -> {
                    Text("Failed to load bookings")
                }

                is BookingUiState.Loading -> {
                    Text("Loading bookings")
                }

                else -> {}
            }
        }

        // 🔹 Bottom spacing
        item {
            Spacer(modifier = Modifier.height(24.dp))
        }

        item {
            CourseHighlightCard(
                course = CourseUiModel(
                    title = "Foundations of UX Design",
                    subtitle = "Instructor: Marsh Hove • Beginner Friendly",
                    meta = "6 Modules • 19h 59m",
                    imageRes = R.drawable.icons_person,
                    backgroundColor = Light_Grey.value.toInt()
                ), modifier = Modifier.padding(16.dp), onClick = { println("Cards") })
        }
    }
}


@Preview
@Composable
private fun PreViewSearchToolbar() {
    HomeScreen()
}
