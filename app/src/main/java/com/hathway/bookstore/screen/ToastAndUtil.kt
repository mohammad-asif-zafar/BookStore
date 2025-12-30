package com.hathway.bookstore.screen

import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp

@Composable
fun ShowToast(message: String) {
    val context = LocalContext.current

    Toast.makeText(
        context, message, Toast.LENGTH_SHORT
    ).show()
}

@Composable
fun CustomToast(
    message: String, show: Boolean
) {
    if (show) {
        Box(
            modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.BottomCenter
        ) {
            Surface(
                modifier = Modifier.padding(16.dp),
                shape = RoundedCornerShape(8.dp),
                color = Color.Black.copy(alpha = 0.8f)
            ) {
                Text(
                    text = message, modifier = Modifier.padding(12.dp), color = Color.White
                )
            }
        }
    }
}