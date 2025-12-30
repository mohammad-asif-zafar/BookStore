package com.hathway.bookstore.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun CircularButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    size: Dp = 40.dp,
    borderColor: Color = Color.Gray,
    iconTint: Color = Color.Black
) {
    Box(
        modifier = modifier
            .size(size)
            .clip(CircleShape)
            .border(
                width = 1.dp, color = borderColor, shape = CircleShape
            )
            .clickable { onClick() }, contentAlignment = Alignment.Center
    ) {
        Icon(
            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
            contentDescription = "Back",
            tint = iconTint
        )
    }
}

@Composable
fun FilledCircularBackButton(
    onClick:  () -> Unit,
    modifier: Modifier = Modifier,
    size: Dp = 40.dp,
    icon: ImageVector,
    contentDescription: String? = null,
    backgroundColor: Color = MaterialTheme.colorScheme.surface,
    iconTint: Color = MaterialTheme.colorScheme.onSurface,
    elevation: Dp = 4.dp,
    border: BorderStroke? = null
) {
    Surface(
        modifier = modifier.size(size),
        shape = CircleShape,
        color = backgroundColor,
        tonalElevation = elevation,
        border = border,
        onClick = onClick
    ) {
        Box(contentAlignment = Alignment.Center) {
            Icon(
                imageVector = icon, contentDescription = contentDescription, tint = iconTint
            )
        }
    }
}

@Preview
@Composable
private fun PreviewCircularButton() {/*   CircularButton(
           onClick = { })*/
    FilledCircularBackButton(
        onClick = { },
        icon = Icons.Default.Close,
        backgroundColor = Color.Transparent,
        iconTint = Color.Black,
        elevation = 0.dp,
        border = BorderStroke(1.dp, Color.Gray)
    )
}