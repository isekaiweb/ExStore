package com.android.developer.exstore.presentation.feature.product.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Edit
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.android.developer.exstore.R
import com.android.developer.exstore.presentation.components.DefaultTextField

@Composable
fun InputOptions(modifier: Modifier = Modifier) {
    var note by remember { mutableStateOf("") }
    var isEdited by remember { mutableStateOf(false) }

    var qty by remember { mutableStateOf(0) }

    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
    ) {
        AddNote(note = note,
            updateNote = { value -> note = value }) { value ->
            isEdited = value
        }
        Quantity(qty = qty) { value ->
            qty = value
        }
    }


}


@Composable
private fun Quantity(
    qty: Int,
    updateQty: (Int) -> Unit,
) {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        IconButtonQty(
            updateQty = { if (qty > 0) updateQty(qty - 1) },
            icon = R.drawable.ic_remove,
        )
        Text(
            text = qty.toString(),
            style = MaterialTheme.typography.bodyLarge.copy(textAlign = TextAlign.Center),
            modifier = Modifier
                .widthIn(max = 100.dp)
                .padding(horizontal = 16.dp)
        )
        IconButtonQty(updateQty = { updateQty(qty + 1) }, icon = R.drawable.ic_add)
    }
}

@Composable
private fun IconButtonQty(
    updateQty: () -> Unit,
    @DrawableRes icon: Int,
) {
    IconButton(
        onClick = updateQty,
        modifier = Modifier.background(
            color = MaterialTheme.colorScheme.inverseSurface,
            shape = MaterialTheme.shapes.large
        )
    ) {
        Icon(
            painter = painterResource(id = icon),
            contentDescription = null,
            tint = MaterialTheme.colorScheme.inverseOnSurface
        )
    }
}

@Composable
private fun AddNote(
    note: String,
    updateNote: (String) -> Unit,
    getFocus: (Boolean) -> Unit
) {
    DefaultTextField(
        text = note,
        colorBorder = MaterialTheme.colorScheme.primary,
        hint = "Add Note",
        onValueChange = updateNote,
        isFocus = getFocus,
        trailingIcon = {
            Icon(
                imageVector = Icons.Rounded.Edit,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.primary
            )
        },
        colorHint = MaterialTheme.colorScheme.primary,
        modifier = Modifier.fillMaxWidth(0.6f),
        useAllCostumeModifier = true,
    )
}