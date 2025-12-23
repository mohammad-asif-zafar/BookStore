package com.hathway.bookstore.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.hathway.bookstore.R // ✅ Correct import for your app resources

@Composable
fun SearchToolbar(
    modifier: Modifier = Modifier, onProfileClick: () -> Unit, onSearchChange: (String) -> Unit
) {
    var searchText by remember { mutableStateOf("") }

    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        // 🔍 Search field (left)
        OutlinedTextField(
            value = searchText,
            onValueChange = {
                searchText = it
                onSearchChange(it)
            },
            placeholder = { Text("Search") },
            singleLine = true,
            leadingIcon = {
                Icon(Icons.Default.Search, contentDescription = null)
            },
            modifier = Modifier
                .weight(1f)
                .height(56.dp),
            shape = RoundedCornerShape(24.dp),
            trailingIcon = {
              // 👤 Profile icon (right)
                Image(
                    painter = painterResource(id = R.drawable.icons_person), // ✅ use your drawable name
                    contentDescription = "Profile",
                    modifier = Modifier
                        .size(35.dp)
                        .clip(CircleShape)
                        .clickable { onProfileClick() })
            })



    }
}
