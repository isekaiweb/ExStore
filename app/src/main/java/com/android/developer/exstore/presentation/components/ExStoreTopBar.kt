package com.android.developer.exstore.presentation.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material.icons.rounded.ShoppingBag
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun ExStoreTopBar(openMenu: () -> Unit, openCart: () -> Unit) {
    val colorOnSurfaceVariant = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.9f)
    CenterAlignedTopAppBar(
        title = { Title() },
        navigationIcon = { NavigationIcon(colorOnSurfaceVariant, openMenu) },
        actions = { ActionMenu(colorOnSurfaceVariant = colorOnSurfaceVariant, openCart = openCart) },
    )
}

@Composable
private fun Title() {
    Text(
        text = buildAnnotatedString {
            addStyle(
                SpanStyle(
                    color = MaterialTheme.colorScheme.primary,
                    fontWeight = FontWeight.Bold
                ),
                0,
                2
            )
            append("Ex")
            pushStyle(
                SpanStyle(
                    color = MaterialTheme.colorScheme.tertiary,
                    fontWeight = FontWeight.Medium
                )
            )
            append("Store")
        },
    )
}

@Composable
private fun NavigationIcon(
    colorOnSurfaceVariant: Color,
    openMenu: () -> Unit
) {

    IconButton(
        onClick = openMenu,
    ) {
        Icon(
            imageVector = Icons.Rounded.Menu,
            contentDescription = "Menu",
            modifier = Modifier
                .border(
                    1.dp, color = colorOnSurfaceVariant,
                    shape = MaterialTheme.shapes.medium
                )
                .padding(8.dp),
            tint = colorOnSurfaceVariant,
        )
    }
}

@Composable
private fun ActionMenu(colorOnSurfaceVariant: Color, openCart: () -> Unit) {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.border(
            1.dp, color = colorOnSurfaceVariant,
            shape = MaterialTheme.shapes.medium
        ),
    ) {
        IconButton(onClick = openCart) {
            Icon(
                imageVector = Icons.Rounded.ShoppingBag, contentDescription = "Cart",
                tint = colorOnSurfaceVariant,
            )
        }

        Badge(
            modifier = Modifier
                .padding(end = 8.dp)
                .height(30.dp)
                .width(30.dp),
            containerColor = MaterialTheme.colorScheme.primary,
        ) {
            Text(
                text = "2",
                style = MaterialTheme.typography.titleMedium.copy(
                    textAlign = TextAlign.Center
                )
            )
        }

    }
}