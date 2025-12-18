package com.hathway.bookstore.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun DetailsScreen(
    userId: Int, onBack: () -> Unit
) {
    Column {
        Text("User ID: $userId")
        Button(onClick = onBack) {
            Text("Back")
        }
    }
}
