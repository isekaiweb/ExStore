package com.android.developer.exstore.presentation.feature.product.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.android.developer.exstore.presentation.components.ItemExStore
import kotlin.random.Random

@Composable
fun OptionsExStore(
    modifier: Modifier = Modifier,
) {
    var selectedOption by remember { mutableStateOf("") }

    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(horizontal = 16.dp),
        modifier = modifier
    ) {
        items(4) {
            Option(
                name = "Option $it",
                desc = "Description $it",
                price = remember { mutableStateOf(Random.nextLong(1000, 100000)) }.value,
                isSelected = selectedOption == "Option $it",
                selectOption = { option ->
                    selectedOption = option
                }
            )
        }
    }
}

@Composable
private fun Option(
    name: String,
    desc: String,
    price: Long,
    isSelected: Boolean,
    selectOption: (String) -> Unit,
) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = Color.Transparent,
        ),
        modifier = Modifier
            .border(
                width = 1.dp,
                color = if (isSelected) MaterialTheme.colorScheme.primary
                else MaterialTheme.colorScheme.outline,
                shape = MaterialTheme.shapes.large
            ).widthIn(min = 120.dp),
        shape = MaterialTheme.shapes.large,
        onClick = { selectOption(name)
        }

    ) {
       Column(modifier = Modifier.padding(8.dp)) {
           ItemExStore(name = name, desc = desc, price = price)
       }
    }

}