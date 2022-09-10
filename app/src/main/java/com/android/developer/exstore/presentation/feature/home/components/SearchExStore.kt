package com.android.developer.exstore.presentation.feature.home.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.android.developer.exstore.R
import com.android.developer.exstore.presentation.components.DefaultTextField


@Composable
fun SearchExStore(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier

    ) {

        var query by remember { mutableStateOf("") }
        val colorFocus = MaterialTheme.colorScheme.onBackground
        val colorUnFocus = MaterialTheme.colorScheme.outline
        var colorBorder by remember { mutableStateOf(colorUnFocus) }


        SearchProduct(
            query = query,
            onQueryChange = { newQuery ->
                query = newQuery
            },
            hint = "Search product or items",
            colorBorder = colorBorder,
            onFocusChanging = { hasFocus ->
                colorBorder = if (hasFocus) {
                    colorFocus
                } else {
                    colorUnFocus
                }
            },
            modifier = Modifier.padding(bottom = 10.dp)
        )
    }
}

@Composable
private fun SearchProduct(
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
        shape = MaterialTheme.shapes.large,
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