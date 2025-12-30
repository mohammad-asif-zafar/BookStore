package com.hathway.bookstore.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ToolBar(
    modifier: Modifier = Modifier,
    elevation: Dp = 0.dp,   // 👈 control elevation here
    backgroundColor: Color = MaterialTheme.colorScheme.surfaceContainerLow,

    backEnable: Boolean = true,
    onBackClick: () -> Unit = {},
    backIcon: ImageVector = Icons.AutoMirrored.Filled.ArrowBack,
    backIconTint: Color = Color.Black,
    backGroundColor: Color = Color.Transparent,
    backBorder: Dp = 1.dp,
    backBorderColor: Color = Color.Gray,
    backElevation: Dp = 4.dp,

    title: String = "Screen Title",

    titleColor: Color = Color.Black,
    titleSize: TextUnit = 16.sp,
    titleWeight: FontWeight = FontWeight.Normal,
    titleAlignment: Alignment.Horizontal = Alignment.Start,

    middleEnable: Boolean = true,
    onMiddleClick: () -> Unit = {},
    middleIcon: ImageVector = Icons.AutoMirrored.Filled.ArrowBack,
    middleIconTint: Color = Color.Black,
    middleGroundColor: Color = Color.Transparent,
    middleElevation: Dp = 0.dp,
    middleBorder: Dp = 1.dp,
    middleBorderColor: Color = Color.Gray,

    endEnable: Boolean = true,
    onEndClick: () -> Unit = {},
    endIcon: ImageVector = Icons.AutoMirrored.Filled.ArrowBack,
    endIconTint: Color = Color.Black,
    endGroundColor: Color = Color.Transparent,
    endBorder: Dp = 1.dp,
    endBorderColor: Color = Color.Gray,
    endElevation: Dp = 0.dp,

    ) {

    var text by remember { mutableStateOf("") }
    Surface(
        modifier = modifier
            .fillMaxWidth()
            .shadow(elevation, shape = RectangleShape),
        color = backgroundColor,
        tonalElevation = elevation,   // ✅ Material 3 shadow
        shadowElevation = elevation   // ✅ visible shadow
    ) {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            // ⬅️ Back button

            if (backEnable) FilledCircularBackButton(
                onClick = { { onBackClick } },
                icon = backIcon,
                backgroundColor = backGroundColor,
                iconTint = backIconTint,
                elevation = backElevation,
                border = BorderStroke(backBorder, backBorderColor)
            )

            Spacer(modifier = Modifier.width(12.dp))
            // 🏷 Title
            Text(
                text = title, style = MaterialTheme.typography.titleMedium.copy(
                    color = titleColor, fontSize = titleSize, fontWeight = titleWeight
                )
            )
            // 🚀 Push everything after this to the end
            Spacer(modifier = Modifier.weight(1f))
            // 🏆 Middle icon
            if (middleEnable) FilledCircularBackButton(
                onClick = { onMiddleClick },
                icon = middleIcon,
                backgroundColor = middleGroundColor,
                iconTint = middleIconTint,
                elevation = middleElevation,
                border = BorderStroke(middleBorder, middleBorderColor)
            )
            Spacer(modifier = Modifier.width(8.dp))

            // 🔔 End icon
            if (endEnable) FilledCircularBackButton(
                onClick = { onEndClick },
                icon = endIcon,
                backgroundColor = endGroundColor,
                iconTint = endIconTint,
                elevation = endElevation,
                border = BorderStroke(endBorder, endBorderColor)
            )

        }
    }
}

@Preview
@Composable
private fun PreviewToolBar() {
    ToolBar()
}