package com.android.developer.exstore.domain.usecase

class NumberToText {
    operator fun invoke(number: Int): String {
        return when (number) {
            0 -> "nol"
            1 -> "satu"
            2 -> "dua"
            3 -> "tiga"
            4 -> "empat"
            5 -> "lima"
            6 -> "enam"
            7 -> "tujuh"
            8 -> "delapan"
            9 -> "sembilan"
            10 -> "sepuluh"
            11 -> "sebelas"
            100 -> "seratus"
            1000 -> "seribu"
            in 12..19 -> {
                val units = number % 10
                "${invoke(units)} belas"
            }
            in 20..99 -> {
                val tens = number / 10
                val units = number % 10
                if (units == 0) {
                    "${invoke(tens)} puluh"
                } else {
                    "${invoke(tens)} puluh ${invoke(units)}"
                }
            }
            in 101..999 -> {
                val hundreds = number / 100
                val tens = number % 100
                when (hundreds) {
                    1 -> {
                        if (tens == 0) {
                            "seratus"
                        } else {
                            "seratus ${invoke(tens)}"
                        }
                    }
                    else -> {
                        if (tens == 0) {
                            "${invoke(hundreds)} ratus"
                        } else {
                            "${invoke(hundreds)} ratus ${invoke(tens)}"
                        }
                    }
                }
            }
            in 1001..999999 -> {
                val thousands = number / 1000
                val hundreds = number % 1000


                when (thousands) {
                    1 -> {
                        if (hundreds == 0) {
                            "seribu"
                        } else {
                            "seribu ${invoke(hundreds)}"
                        }
                    }
                    else -> {
                        if (hundreds == 0) {
                            "${invoke(thousands)} ribu"
                        } else {
                            "${invoke(thousands)} ribu ${invoke(hundreds)}"
                        }
                    }
                }

            }
            else -> throw IllegalArgumentException("Number is too big")
        }
    }
}