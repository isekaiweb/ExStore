package com.android.developer.exstore.presentation.feature.menu.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.android.developer.exstore.R

@Composable
fun SectionHeader(
    menuSelected: String,
    modifier: Modifier = Modifier,
) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier,
    ) {
        Image(
            painter = painterResource(id = R.drawable.photo),
            contentDescription = null, modifier = Modifier
                .clip(CircleShape)
                .border(1.dp, MaterialTheme.colorScheme.onSurface, CircleShape)
                .size(60.dp)

        )
        Column {
            Text(text = "Abraham", style = MaterialTheme.typography.titleMedium.copy(color = MaterialTheme.colorScheme.onBackground))
            Text(text = menuSelected, style = MaterialTheme.typography.bodySmall.copy(color = MaterialTheme.colorScheme.onBackground))
        }
    }
}