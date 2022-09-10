package com.android.developer.exstore.presentation.feature.menu

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.android.developer.exstore.R
import com.android.developer.exstore.presentation.feature.menu.components.SectionFooter
import com.android.developer.exstore.presentation.feature.menu.components.SectionHeader
import com.android.developer.exstore.presentation.feature.menu.components.SectionMenu
import kotlin.random.Random

@Composable
fun MenuDrawer(
    context: Context
) {
    val selectedMenu =
        rememberSaveable { mutableStateOf(context.getString(R.string.label_dashboard)) }
//    val img by remember { mutableStateOf("https://picsum.photos/seed/${Random.nextInt()}/300/200") }


    Column(
        modifier = Modifier
            .width(300.dp)
            .fillMaxHeight()
            .background(color = MaterialTheme.colorScheme.background),
        verticalArrangement = Arrangement.Top
    ) {

        SectionHeader(
            menuSelected = selectedMenu.value,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .weight(1f, false)
        )

        SectionMenu(
            modifier = Modifier
                .padding(horizontal = 8.dp)
                .fillMaxWidth()
                .weight(3f),
            selectedMenu = selectedMenu.value,
            contentPadding = PaddingValues(vertical = 4.dp),
        ) { text -> selectedMenu.value = context.getString(text) }


        SectionFooter(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp)
                .weight(1f, false),
            contentPadding = PaddingValues(vertical = 4.dp),
        )
    }

}