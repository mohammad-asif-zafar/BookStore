package com.hathway.bookstore.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.hathway.bookstore.components.SearchToolbar

@Composable
fun HomeScreen(

) {
    SearchToolbar(modifier = Modifier, onProfileClick = {}, onSearchChange = {})
}

@Preview
@Composable
private fun PreViewSearchToolbar() {
    SearchToolbar(modifier = Modifier, onProfileClick = {}, onSearchChange = {})
}
