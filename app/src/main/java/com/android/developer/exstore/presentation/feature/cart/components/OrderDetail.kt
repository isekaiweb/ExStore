package com.android.developer.exstore.presentation.feature.cart.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.android.developer.exstore.presentation.util.toReadAble
import kotlin.random.Random

@Composable
fun OrderDetail(
    modifier: Modifier = Modifier,
) {
    Text(
        text = "MAIN COURSE",
        style = MaterialTheme.typography.labelSmall.copy(
            color = MaterialTheme.colorScheme.outline.copy(alpha = 0.8f)
        ),
    )
    Spacer(modifier = Modifier.height(8.dp))
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier
    ) {
        items(5) {
            val img =
                rememberSaveable { mutableStateOf("https://picsum.photos/seed/${Random.nextInt()}/300/200") }.value
            val qty = rememberSaveable { mutableStateOf(Random.nextInt(1, 8)) }.value
            val price = remember { mutableStateOf(Random.nextLong(100000, 100000000)) }.value
            OrderItem(
                img = img,
                qty = qty,
                note = if (qty % 2 == 0) "note $it" else null,
                price = price,
                name = "Item $it"
            )
        }
    }
}

@Composable
private fun OrderItem(
    img: String,
    qty: Int,
    note: String?,
    price: Long,
    name: String,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        , horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Text(
                text = "x$qty",
                style = MaterialTheme.typography.labelSmall,
                color = MaterialTheme.colorScheme.primary
            )
            Image(
                painter = rememberAsyncImagePainter(model = img),
                contentDescription = null,
                modifier = Modifier
                    .size(120.dp)
                    .aspectRatio(3f / 2f).clip(MaterialTheme.shapes.medium)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Column {
                Text(
                    text = name,
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.onBackground
                )
                if (note != null) {
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = note,
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onBackground
                    )
                }
            }
        }
        Text(text = buildAnnotatedString {
            pushStyle(SpanStyle(fontWeight = FontWeight.Bold, fontSize = 12.sp))
            append("Rp. ")
            pop()
            pushStyle(SpanStyle(fontSize = 16.sp, fontWeight = FontWeight.Bold))
            append(price.toReadAble())
        })
    }
}