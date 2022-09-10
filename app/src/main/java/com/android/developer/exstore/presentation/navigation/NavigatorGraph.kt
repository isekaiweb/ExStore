package com.android.developer.exstore.presentation.navigation

import com.android.developer.exstore.presentation.feature.cart.navigator.CartNavigator
import com.android.developer.exstore.presentation.feature.destinations.CheckoutScreenDestination
import com.android.developer.exstore.presentation.feature.destinations.ProductScreenDestination
import com.android.developer.exstore.presentation.feature.home.navigator.HomeNavigator
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

class NavigatorGraph(
    private val navigator: DestinationsNavigator,
) : HomeNavigator, CartNavigator {
    override fun openProduct(productName: String) {
        navigator.navigate(ProductScreenDestination(productName), onlyIfResumed = true)
    }

    override fun checkout(totalPrice: Long) {
        navigator.navigate(CheckoutScreenDestination(totalPrice), onlyIfResumed = true)
    }
}