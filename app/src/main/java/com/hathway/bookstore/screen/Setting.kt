package com.hathway.bookstore.screen

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.outlined.EmojiEvents
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hathway.bookstore.R
import com.hathway.bookstore.components.ToolBar

@Composable
fun SettingScreen(

) {
    ToolBar(
        modifier = Modifier.fillMaxWidth(),

        // ⬅️ Back button
        backEnable = false,
        onBackClick = {
            println("Back clicked")
        },
        backIcon = Icons.AutoMirrored.Filled.ArrowBack,
        backIconTint = Color.Black,
        backGroundColor = Color.Transparent,
        backBorder = 1.dp,
        backBorderColor = Color.Gray,
        backElevation = 4.dp,

        // 🏷 Title
        title = stringResource(id = R.string.setting),
        titleColor = Color.Black,
        titleSize = 16.sp,
        titleWeight = FontWeight.Medium,
        titleAlignment = Alignment.Start, // (note: not used in Row)

        // 🏆 Middle icon (Leaderboard)
        middleEnable = true,
        onMiddleClick = {
            println("Leaderboard clicked")
        },
        middleIcon = Icons.Outlined.EmojiEvents,
        middleIconTint = Color.Black,
        middleGroundColor = Color.Transparent,
        middleElevation = 4.dp,
        middleBorder = 1.dp,
        middleBorderColor = Color.Gray,

        // 🔔 End icon (Notifications)
        endEnable = true,
        onEndClick = {
            println("Notifications clicked")
        },
        endIcon = Icons.Outlined.Notifications,
        endIconTint = Color.Black,
        endGroundColor = Color.Transparent,
        endBorder = 1.dp,
        endBorderColor = Color.Gray,
        endElevation = 4.dp
    )

}