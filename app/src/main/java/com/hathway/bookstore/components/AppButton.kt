package com.hathway.bookstore.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun AppButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    label: String,
    loading: Boolean = false,
    enabled: Boolean = true,
    textColor: Color,
    bgColor: Color
) {
    Button(
        onClick = onClick,
        enabled = enabled && !loading,
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = bgColor,
            contentColor = textColor,
            disabledContainerColor = bgColor.copy(alpha = 0.5f),
            disabledContentColor = textColor.copy(alpha = 0.7f)
        )
    ) {
        if (loading) {
            CircularProgressIndicator(
                modifier = Modifier.size(18.dp), strokeWidth = 2.dp, color = textColor
            )
        } else {
            Text(label)

            Spacer(modifier = Modifier.width(8.dp))

            Icon(
                imageVector = Icons.Default.Send, contentDescription = null
            )
        }
    }
}

@Preview
@Composable
private fun previewAppButton() {
    AppButton(
        modifier = Modifier,
        onClick = {},
        loading = false,
        label = "Send successfully",
        enabled = true,
        textColor = MaterialTheme.colorScheme.onPrimary,
        bgColor = MaterialTheme.colorScheme.primary
    )

}
