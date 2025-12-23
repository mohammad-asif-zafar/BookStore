package com.hathway.bookstore.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun AppTextFiled(
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    placeholder: String = "",
    supportingText: String = "",
    isError: Boolean = false,
    keyboardType: KeyboardType = KeyboardType.Text,
    leadingIcon: ImageVector? = null

) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(label) },
        placeholder = { Text(placeholder) },
        singleLine = true,
        isError = isError,
        keyboardOptions = KeyboardOptions(
            keyboardType = keyboardType
        ),
        leadingIcon = if (leadingIcon != null) {
            {
                Icon(
                    imageVector = leadingIcon,
                    contentDescription = null
                )
            }
        } else {
            null // 👈 THIS removes the reserved space
        },
        supportingText = {
            if (isError && supportingText.isNotEmpty()) {
                Text(supportingText)
            }
        },
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(12.dp)
    )
}

@Preview
@Composable
private fun TextFiled() {
    var email by remember { mutableStateOf("") }

    AppTextFiled(
        value = email,
        onValueChange = { email = it },
        label = "Email",
        placeholder = "name@example.com",
        keyboardType = KeyboardType.Email,
        leadingIcon = Icons.Default.Email,
        isError = email.isNotEmpty() && !email.contains("@"),
        supportingText = "Enter a valid email address"
    )
}