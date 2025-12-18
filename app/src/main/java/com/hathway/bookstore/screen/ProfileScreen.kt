package com.hathway.bookstore.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun ProfileScreen(onBack: () -> Unit) {
    Column {
        Text("Profile Screen")
        Button(onClick = onBack) {
            Text("Back")
        }
    }
}