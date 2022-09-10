package com.android.developer.exstore.presentation.feature.menu.components

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.android.developer.exstore.R

@Composable
fun SectionFooter(
    contentPadding: PaddingValues,
    modifier: Modifier = Modifier,
) {


    Column(modifier = modifier) {

        Divider(modifier = Modifier.padding(contentPadding))

        Footer.values().forEach { item ->
            val color = item.color ?: MaterialTheme.colorScheme.onSurfaceVariant
            NavigationDrawerItem(
                modifier = Modifier.padding(contentPadding),
                label = {
                    Text(
                        text = stringResource(id = item.text),
                        style = MaterialTheme.typography.titleMedium
                    )
                },
                icon = {
                    Icon(
                        painter = painterResource(id = item.icon),
                        contentDescription = null,
                    )
                },
                selected = false, onClick = {},
                shape = MaterialTheme.shapes.medium,
                colors = NavigationDrawerItemDefaults.colors(
                    unselectedIconColor = color,
                    unselectedTextColor = color
                )
            )
        }

    }
}


private enum class Footer(
    @DrawableRes val icon: Int, @StringRes val text: Int,
    val color: Color? = null,
) {
    HELP(R.drawable.ic_live_help, R.string.label_help),
    LOGOUT(R.drawable.ic_logout, R.string.label_logout, Color.Red),
}