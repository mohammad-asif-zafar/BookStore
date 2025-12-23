package com.hathway.bookstore.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun AppText(
    text: String, modifier: Modifier = Modifier, color: Color, style: TextStyle,
    fontSize: TextUnit = 14.sp
) {
    Box(
        modifier = Modifier,
        contentAlignment = Alignment.TopStart
    ) {
        Text(
            text = text,
            modifier = modifier,
            color = color,
            style = style,
            fontSize = fontSize

        )
    }
}

@Preview
@Composable
private fun AppTextPreview() {
    AppText(
        modifier = Modifier
            .padding(10.dp)
            .background(Color.Red)
            .clickable(onClick = {  })
            .size(width = 100.dp, height = 50.dp)
            .fillMaxWidth()
            .fillMaxHeight(),
        text = "Hello Compose",
        color = Color.Black,
        fontSize = 8.sp,
        style = TextStyle.Default


    )

}
