package com.android.developer.exstore.presentation.feature.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.android.developer.exstore.presentation.feature.home.components.ChipsExStore
import com.android.developer.exstore.presentation.feature.home.components.ProductExStore
import com.android.developer.exstore.presentation.feature.home.components.SearchExStore
import com.android.developer.exstore.presentation.feature.home.navigator.HomeNavigator
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph

@RootNavGraph(start = true)
@Destination
@Composable
fun HomeScreen(
    navigator: HomeNavigator,
) {
    Column(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.surfaceVariant)
            .fillMaxSize()
    ) {
        SearchExStore(
            modifier = Modifier
                .background(color = MaterialTheme.colorScheme.background)
                .padding(horizontal = 8.dp, vertical = 20.dp)
        )

        ChipsExStore(
            modifier = Modifier.padding(vertical = 16.dp),
            contentPadding = PaddingValues(start = 8.dp)
        )

        ProductExStore(
            modifier = Modifier.padding(horizontal = 8.dp),
            getProduct = navigator::openProduct
        )
    }
}