package com.android.developer.exstore.presentation.feature.cart.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Delete
import androidx.compose.material.icons.rounded.Edit
import androidx.compose.material.icons.rounded.Face
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

@Composable
fun OrderInfo(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
    ) {
        Text(
            text = "Order #321 Product 1",
            style = MaterialTheme.typography.labelLarge.copy(color = MaterialTheme.colorScheme.onBackground)
        )
        Spacer(modifier = Modifier.height(8.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Icon(
                    imageVector = Icons.Rounded.Face,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.background(
                        color = MaterialTheme.colorScheme.surfaceVariant,
                        shape = MaterialTheme.shapes.medium
                    ).padding(4.dp)
                )

                Text(
                    text = "Abraham",
                    style = MaterialTheme.typography.titleLarge.copy(color = MaterialTheme.colorScheme.onBackground)
                )
            }

            Row(horizontalArrangement = Arrangement.spacedBy(2.dp)) {
                IconButtonOrder(icon = Icons.Rounded.Edit) { }
                IconButtonOrder(icon = Icons.Rounded.Delete) { }
            }
        }
    }
}

@Composable
private fun IconButtonOrder(
    icon: ImageVector,
    onClick: () -> Unit
) {
    IconButton(onClick = onClick) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}