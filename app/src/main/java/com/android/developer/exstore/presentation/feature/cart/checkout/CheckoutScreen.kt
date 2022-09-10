package com.android.developer.exstore.presentation.feature.cart.checkout

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.android.developer.exstore.presentation.components.DefaultButton
import com.android.developer.exstore.presentation.feature.cart.checkout.components.BillInfo
import com.android.developer.exstore.presentation.feature.cart.checkout.components.DiscountInfo
import com.android.developer.exstore.presentation.util.toReadAble
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.spec.DestinationStyle

@Destination(
    style = DestinationStyle.BottomSheet::class
)
@Composable
fun CheckoutScreen(
    totalPrice: Long
) {

    val tax = (totalPrice * 0.02).toLong()
    val discount = (totalPrice * 0.1).toLong()

    Column(modifier = Modifier.padding(horizontal = 16.dp, vertical = 24.dp)) {
        DiscountInfo(
            modifier = Modifier
                .fillMaxWidth()
                .border(
                    1.dp,
                    color = MaterialTheme.colorScheme.primary,
                    shape = MaterialTheme.shapes.medium
                )
                .padding(8.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))
        BillInfo(totalPrice = totalPrice, tax = tax, discount = discount)
        Spacer(modifier = Modifier.height(24.dp))
        DefaultButton(
            text = "Charge Rp. ${(totalPrice + tax - discount).toReadAble()}",
            onClick = { },
            modifier = Modifier.fillMaxWidth()
        )
    }
}