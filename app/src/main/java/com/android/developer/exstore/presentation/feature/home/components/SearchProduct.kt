package com.android.developer.exstore.presentation.feature.home.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import com.android.developer.exstore.R
import com.android.developer.exstore.ui.components.DefaultTextField

@Composable
fun SearchProduct(
    query: String,
    onQueryChange: (String) -> Unit,
    hint: String,
    colorBorder: Color,
    onFocusChanging: (Boolean) -> Unit,
    modifier: Modifier = Modifier
) {
    DefaultTextField(
        modifier = modifier,
        text = query,
        colorBorder = colorBorder,
        hint = hint,
        roundedSize = 10,
        onValueChange = onQueryChange,
        isFocus = onFocusChanging,
        leadingIcon = {
            Icon(imageVector = Icons.Rounded.Search, contentDescription = null)
        },
        trailingIcon = {
            Icon(
                painter = painterResource(id = R.drawable.ic_qr_code_scanner),
                contentDescription = null,
                tint = MaterialTheme.colorScheme.onSurface
            )
        }
    )
}