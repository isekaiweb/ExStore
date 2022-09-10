package com.android.developer.exstore.presentation.feature.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import kotlin.random.Random

@Composable
fun ProductExStore(
    modifier: Modifier = Modifier,
    getProduct: () -> Unit,
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        modifier = modifier
    ) {
        items(10) {
            val img =
                rememberSaveable { mutableStateOf("https://picsum.photos/seed/${Random.nextInt()}/300/200") }
            Product(
                img = img.value,
                name = "Product $it",
                desc = "Description $it",
                price = Random.nextLong(100000, 100000000),
                getProduct = getProduct
            )
        }
    }
}


@Composable
private fun Product(
    img: String,
    name: String,
    desc: String,
    price: Long,
    getProduct: () -> Unit,
) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.background,

            ),
        onClick = getProduct,
    ) {
        Image(
            painter = rememberAsyncImagePainter(model = img), contentDescription = desc,
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(3f / 2f)
        )
        Column(modifier = Modifier.padding(vertical = 16.dp, horizontal = 8.dp)) {
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
    }
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