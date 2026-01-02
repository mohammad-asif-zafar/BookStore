@file:Suppress("CAST_NEVER_SUCCEEDS")

package com.hathway.bookstore.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hathway.bookstore.R
import com.hathway.bookstore.data.BookingCourseUiModel
import com.hathway.bookstore.ui.theme.GreenAccent

@Composable
fun CourseBookingCard(
    course: BookingCourseUiModel,
    modifier: Modifier = Modifier,
    onBookClick: () -> Unit = {}
) {
    Surface(
        modifier = modifier
            .width(220.dp).padding(end = 10.dp),
        shape = RoundedCornerShape(20.dp),
        color = MaterialTheme.colorScheme.surface,
        tonalElevation = 4.dp,
        shadowElevation = 4.dp,
        onClick = onBookClick

    ) {
        Column(
            modifier = Modifier.padding(12.dp)
        ) {

            // 🎨 Image container
            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(140.dp),
                shape = RoundedCornerShape(16.dp),
                color = course.imageBackground
            ) {
                Image(
                    painter = painterResource(course.imageRes),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )
            }

            Spacer(modifier = Modifier.height(12.dp))

            // 📘 Title
            Text(
                text = course.title,
                style = MaterialTheme.typography.bodyMedium.copy(
                    fontWeight = FontWeight.SemiBold
                ),
                maxLines = 2
            )

            Spacer(modifier = Modifier.height(12.dp))

            // 💰 Price + Button
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = course.price,
                    style = MaterialTheme.typography.bodyMedium.copy(
                        fontWeight = FontWeight.Bold
                    )
                )

                Spacer(modifier = Modifier.weight(1f))

                // 🟢 Book now button
                Surface(
                    shape = RoundedCornerShape(50),
                    color = Color.Black,
                    onClick = onBookClick
                ) {
                    Text(
                        text = "Book now",
                        modifier = Modifier.padding(
                            horizontal = 16.dp,
                            vertical = 8.dp
                        ),
                        color = Color.White,
                        style = MaterialTheme.typography.labelMedium
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewCourseBookingCard() {
    CourseBookingCard(
        course = BookingCourseUiModel(
            title = "Mastering of graphic Design",
            price = "$499.00",
            imageRes = R.drawable.icons_person,
            imageBackground = GreenAccent // pink background
        ),
        modifier = Modifier.padding(16.dp)
    )
}