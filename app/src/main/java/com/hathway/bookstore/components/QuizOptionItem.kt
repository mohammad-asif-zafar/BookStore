package com.hathway.bookstore.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.hathway.bookstore.data.QuizOption

@Composable
fun QuizOptionItem(
    option: QuizOption, selected: Boolean, modifier: Modifier = Modifier, onClick: () -> Unit
) {
    val borderColor = when {
        selected && option.isCorrect -> Color(0xFF8BC34A)
        selected -> Color.Black
        else -> Color.Gray
    }

    Surface(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(50),
        border = BorderStroke(1.5.dp, borderColor),
        onClick = onClick
    ) {
        Text(
            text = option.text,
            modifier = Modifier.padding(vertical = 14.dp, horizontal = 16.dp),
            style = MaterialTheme.typography.bodyMedium,
            color = Color.Black
        )
    }
}
