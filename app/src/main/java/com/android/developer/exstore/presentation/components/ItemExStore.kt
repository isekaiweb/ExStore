package com.android.developer.exstore.presentation.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ItemExStore(
    name: String,
    desc: String,
    price: Long,

) {
    Text(text = name, style = MaterialTheme.typography.titleMedium)
    Spacer(modifier = Modifier.height(2.dp))
    Text(text = desc, style = MaterialTheme.typography.bodySmall)
    Spacer(modifier = Modifier.height(8.dp))
    Text(text = buildAnnotatedString {
        pushStyle(SpanStyle(fontWeight = FontWeight.Bold, fontSize = 12.sp))
        append("Rp. ")
        pop()
        pushStyle(SpanStyle(fontSize = 16.sp, fontWeight = FontWeight.Bold))
        append(price.toReadAble())
    })
}

private fun Long.toReadAble(): String {
    var result = ""
    var n = 0
    val currency = this.toString().reversed()
    currency.forEach { char ->
        n += 1
        result += if (n % 3 == 0 && n < currency.length) {
            "$char."
        } else char
    }
    return result.reversed()
}