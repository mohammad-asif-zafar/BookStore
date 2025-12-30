package com.hathway.bookstore.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun CapsuleIconButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    iconEnable : Boolean = false,
    icon: ImageVector,
    text: String,
    contentDescription: String? = null,
    backgroundColor: Color = MaterialTheme.colorScheme.surface,
    iconTint: Color = MaterialTheme.colorScheme.onSurface,
    textColor: Color = MaterialTheme.colorScheme.onSurface,
    elevation: Dp = 4.dp,
    border: BorderStroke? = null,
    iconSize: Dp = 18.dp
) {
    Surface(
        modifier = modifier, shape = RoundedCornerShape(50), // 👈 capsule shape
        color = backgroundColor, tonalElevation = elevation, border = border, onClick = onClick
    ) {
        Row(
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            if (iconEnable) Icon(
                imageVector = icon,
                contentDescription = contentDescription,
                tint = iconTint,
                modifier = Modifier.size(iconSize)
            )

            Spacer(modifier = Modifier.width(8.dp))

            Text(
                text = text, style = MaterialTheme.typography.labelLarge, color = textColor
            )
        }
    }
}
