package com.hathway.bookstore.screen

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.hathway.bookstore.components.SearchToolbar

@Composable
fun DetailsScreen(
) {
    SearchToolbar(
        modifier = Modifier,
        onProfileClick = {},
        onSearchChange = {}
    )
}

@Preview
@Composable
private fun DetailPreview() {
    DetailsScreen(

    )
}
