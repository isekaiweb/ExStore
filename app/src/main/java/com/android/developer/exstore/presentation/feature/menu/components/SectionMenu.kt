package com.android.developer.exstore.presentation.feature.menu.components

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.android.developer.exstore.R

@Composable
fun SectionMenu(
    selectedMenu: String,
    contentPadding: PaddingValues,
    modifier: Modifier = Modifier,
    getMenuSelected: (Int) -> Unit,
) {
    Column(modifier = modifier) {
        Menu.values().forEach { item ->
            NavigationDrawerItem(
                modifier = Modifier.padding(contentPadding),
                label = {
                    Text(
                        text = stringResource(id = item.title),
                        style = MaterialTheme.typography.titleMedium
                    )
                },
                icon = {
                    Icon(
                        painter = painterResource(id = item.icon),
                        contentDescription = null,
                    )
                },
                selected = selectedMenu == stringResource(id = item.title),
                onClick = { getMenuSelected(item.title) },
                shape = MaterialTheme.shapes.medium,
                colors = NavigationDrawerItemDefaults.colors(
                    selectedContainerColor = MaterialTheme.colorScheme.primary,
                    selectedIconColor = MaterialTheme.colorScheme.onPrimary,
                    selectedTextColor = MaterialTheme.colorScheme.onPrimary
                )
            )
        }

    }
}


private enum class Menu(@DrawableRes val icon: Int, @StringRes val title: Int) {
    DASHBOARD(icon = R.drawable.ic_dashboard, title = R.string.label_dashboard),
    CASHIER(icon = R.drawable.ic_storefron, title = R.string.label_cashier),
    REPORT(icon = R.drawable.ic_summarize, title = R.string.label_report),
    MANAGEMENT(icon = R.drawable.ic_people, title = R.string.label_management),
    DISCOUNT_VOUCHER(icon = R.drawable.ic_style, title = R.string.label_discount_and_voucher),
    SETTING(icon = R.drawable.ic_settings, title = R.string.label_setting),
}


