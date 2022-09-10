package com.android.developer.exstore.presentation.util

fun Long.toReadAble(): String {
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