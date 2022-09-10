package com.android.developer.exstore.presentation.feature.cart

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.android.developer.exstore.presentation.components.DefaultButton
import com.android.developer.exstore.presentation.feature.cart.components.OrderDetail
import com.android.developer.exstore.presentation.feature.cart.components.OrderInfo
import com.android.developer.exstore.presentation.feature.cart.navigator.CartNavigator
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.spec.DestinationStyle

@Destination(
    style = DestinationStyle.BottomSheet::class
)
@Composable
fun CartScreen(
    navigator: CartNavigator
) {
    val totalPrice = rememberSaveable { mutableStateOf<Long>(0) }

    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize()
    ) {
        Spacer(modifier = Modifier.height(16.dp))
        OrderInfo(
            modifier = Modifier
                .fillMaxWidth()
                .border(
                    1.dp,
                    color = MaterialTheme.colorScheme.outline,
                    shape = MaterialTheme.shapes.medium
                )
                .padding(8.dp)

        )
        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Current Order",
            style = MaterialTheme.typography.headlineMedium.copy(fontWeight = FontWeight.Bold)
        )

        Spacer(modifier = Modifier.height(16.dp))

        OrderDetail(modifier = Modifier.weight(1f)) { price ->
            totalPrice.value += price
        }

        Spacer(modifier = Modifier.height(8.dp))

        DefaultButton(
            text = "Checkout",
            onClick = { navigator.checkout(totalPrice.value) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )

    }
}