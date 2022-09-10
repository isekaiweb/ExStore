package com.android.developer.exstore.presentation.feature.home.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun ChipsExStore(
    contentPadding: PaddingValues,
    modifier: Modifier = Modifier,
) {

    var selectedChip by remember { mutableStateOf(ChipType.ALL) }

    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier
    ) {
        items(ChipType.values()) { item ->
            FilterChip(
                selected = selectedChip == item, onClick = { selectedChip = item },
                label = {
                    Text(
                        text = item.title,
                        style = MaterialTheme.typography.labelLarge,
                        modifier = Modifier.padding(horizontal = 6.dp, vertical = 14.dp)
                    )
                },
                shape = MaterialTheme.shapes.large,
                colors = FilterChipDefaults.elevatedFilterChipColors(
                    selectedContainerColor = MaterialTheme.colorScheme.primary,
                    selectedLabelColor = MaterialTheme.colorScheme.onPrimary,
                    containerColor = Color.Transparent,
                    labelColor = MaterialTheme.colorScheme.onSurfaceVariant,
                ),
                modifier = Modifier.padding(contentPadding)
            )
        }
    }
}

private enum class ChipType(val title: String) {
    ALL("All Items"),
    MAIN("Main Course"),
    POPULAR("Popular"),
    DISCOUNT("Discount")
}