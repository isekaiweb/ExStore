package com.android.developer.exstore.presentation.feature.product

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.android.developer.exstore.presentation.feature.product.components.InputOptions
import com.android.developer.exstore.presentation.feature.product.components.OptionsExStore
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.spec.DestinationStyle

@Destination(
    style = DestinationStyle.BottomSheet::class
)
@Composable
fun ProductScreen(
    productName: String,
) {

    Column {
        Text(
            text = "select option".uppercase(),
            style = MaterialTheme.typography.titleMedium.copy(color = MaterialTheme.colorScheme.outline),
            modifier = Modifier.padding(16.dp)
        )
        OptionsExStore(modifier = Modifier.padding(bottom = 32.dp))
        InputOptions(
            modifier = Modifier
                .padding(bottom = 16.dp, start = 16.dp, end = 16.dp)
                .fillMaxWidth()
        )

        Button(
            onClick = { /*TODO*/ },
            shape = MaterialTheme.shapes.large,
            modifier = Modifier
                .padding(start = 16.dp, end = 16.dp, bottom = 8.dp)
                .fillMaxWidth()
        ) {
            Text(
                text = "Add to cart $productName",
                modifier = Modifier.padding(8.dp),
                style = MaterialTheme.typography.titleMedium
            )
        }

    }
}