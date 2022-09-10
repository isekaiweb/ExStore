package com.android.developer.exstore.presentation.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.plusAssign
import com.android.developer.exstore.presentation.components.ExStoreTopBar
import com.android.developer.exstore.presentation.feature.NavGraphs
import com.android.developer.exstore.presentation.feature.destinations.CartScreenDestination
import com.android.developer.exstore.presentation.feature.menu.MenuDrawer
import com.android.developer.exstore.ui.theme.ExStoreTheme
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.google.accompanist.navigation.material.ModalBottomSheetLayout
import com.google.accompanist.navigation.material.rememberBottomSheetNavigator
import com.ramcosta.composedestinations.DestinationsNavHost
import com.ramcosta.composedestinations.animations.rememberAnimatedNavHostEngine
import com.ramcosta.composedestinations.navigation.dependency
import com.ramcosta.composedestinations.navigation.navigate
import kotlinx.coroutines.launch

@Composable
fun NavApp() {
    val navHostEngine = rememberAnimatedNavHostEngine()
    val bottomSheetNavigator = rememberBottomSheetNavigator()
    val navController = rememberAnimatedNavController()
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val coroutine = rememberCoroutineScope()
    val context = LocalContext.current

    navController.navigatorProvider += bottomSheetNavigator



    ExStoreTheme {
        ModalNavigationDrawer(
            drawerState = drawerState,
            gesturesEnabled = drawerState.isOpen,
            drawerContent = {
                MenuDrawer(context = context)
            }) {
            ModalBottomSheetLayout(
                bottomSheetNavigator = bottomSheetNavigator,
                sheetShape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp)
            ) {
                Scaffold(
                    topBar = {
                        ExStoreTopBar(openCart = {
                            navController.navigate(CartScreenDestination)
                        }, openMenu = {
                            coroutine.launch { drawerState.open() }
                        })
                    }
                ) { value ->
                    DestinationsNavHost(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(value),
                        engine = navHostEngine,
                        navController = navController,
                        navGraph = NavGraphs.root,
                        dependenciesContainerBuilder = {
                            dependency(
                                NavigatorGraph(
                                    navigator = destinationsNavigator,
                                )
                            )
                        }
                    )
                }
            }
        }
    }
}

