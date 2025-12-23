package com.hathway.bookstore.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hathway.bookstore.components.AppButton
import com.hathway.bookstore.components.AppTextFiled

@Composable
fun DetailsScreen(
) {
    Column(modifier = Modifier.padding(16.dp)) {
        var email by remember { mutableStateOf("") }

        AppTextFiled(
            value = email,
            onValueChange = { email = it },
            label = "Email",
            placeholder = "name@example.com",
            keyboardType = KeyboardType.Email,
            isError = email.isNotEmpty() && !email.contains("@"),
            supportingText = "Enter a valid email address"
        )
        AppButton(
            modifier = Modifier,
            onClick = {},
            loading = false,
            label = "Send successfully",
            enabled = true,
            textColor = MaterialTheme.colorScheme.onPrimary,
            bgColor = MaterialTheme.colorScheme.primary
        )

        Spacer(
            modifier = Modifier
                .padding(4.dp)
                .background(Color.White)
        )

        Column(
            horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxWidth()

        ) {
            Text("Title", Modifier.padding(bottom = 16.dp))
            Text("Subtitle")
            Button(onClick = {}) { Text("Continue") }
        }
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Icon(Icons.Default.Email, null)
            Text("Email")
        }
        Row(Modifier.fillMaxWidth()) {
            Text("Left", Modifier.weight(1f))
            Text("Right", Modifier.weight(1f))
        }
        Column(Modifier.fillMaxHeight(0.3f)) {
            Text("Top", Modifier.weight(1f))
            Text("Bottom", Modifier.weight(2f))
        }
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            Text(
                "Top Left", Modifier.align(Alignment.TopStart)
            )
            Text(
                "end", Modifier.align(Alignment.TopEnd)
            )
            Text(
                "top center", Modifier.align(Alignment.TopCenter)
            )
            Text(
                "center", Modifier.align(Alignment.CenterStart)
            )
            Text(
                "center", Modifier.align(Alignment.Center)
            )
            Text(
                "bottom left", Modifier.align(Alignment.BottomStart)
            )
            Text(
                "bottom center", Modifier.align(Alignment.BottomCenter)
            )
            Text(
                "bottom right", Modifier.align(Alignment.BottomEnd)
            )
            Text(
                "Bottom", Modifier.align(Alignment.BottomCenter)
            )

        }
    }
}

@Preview
@Composable
private fun DetailPreview() {
    DetailsScreen(

    )
}
