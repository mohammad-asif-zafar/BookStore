package com.hathway.bookstore.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun HomeScreen(
    onProfileClick: () -> Unit, onDetailsClick: (Int) -> Unit
) {
    Column {
        Button(onClick = onProfileClick) {
            Text("Go to Profile")
        }

        Button(onClick = { onDetailsClick(42) }) {
            Text("Go to Details")
        }
    }
}
