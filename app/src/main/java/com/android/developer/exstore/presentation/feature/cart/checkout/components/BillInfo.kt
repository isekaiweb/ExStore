package com.android.developer.exstore.presentation.feature.cart.checkout.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.android.developer.exstore.presentation.util.toReadAble

@Composable
fun BillInfo(
    totalPrice: Long,
    discount: Long,
    tax: Long,
    modifier: Modifier = Modifier
) {

    ItemBill(
        label = "Subtotal", value = totalPrice,
        style = MaterialTheme.typography.titleSmall
    )
    Spacer(modifier = modifier.height(8.dp))
    ItemBill(label = "Tax (2%)", value = tax)
    Spacer(modifier = modifier.height(4.dp))
    ItemBill(label = "Discount (10%)", value = discount, isDiscount = true)
    Spacer(modifier = modifier.height(16.dp))
    Divider()
    Spacer(modifier = modifier.height(16.dp))
    ItemBill(
        label = "Total", value = totalPrice + tax - discount,
        style = MaterialTheme.typography.titleMedium.copy(
            fontWeight = FontWeight.ExtraBold,
        )
    )
}


@Composable
fun ItemBill(
    label: String,
    value: Long,
    isDiscount: Boolean = false,
    style: TextStyle = MaterialTheme.typography.labelMedium.copy(color = MaterialTheme.colorScheme.outline),
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Text(
            text = label,
            style = style,
        )
        Text(
            text = buildAnnotatedString {
                pushStyle(SpanStyle(fontWeight = FontWeight.Bold, fontSize = style.fontSize/1.2f))
                append("${if (isDiscount) "- " else ""}Rp. ")
                pop()
                pushStyle(SpanStyle(fontSize = style.fontSize, fontWeight = FontWeight.Bold))
                append(value.toReadAble())
            },
            style = style,
        )
    }
}