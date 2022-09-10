package com.android.developer.exstore.domain.usecase

import com.google.common.truth.Truth.assertThat
import org.junit.Test

class NumberToTextTest {

    private val numberToText = NumberToText()

    @Test
    fun `expect dua belas`() {
       val result = numberToText(12)
        assertThat(result).isEqualTo("dua belas")
    }

    @Test
    fun `expect dua ribu dua belas`() {
        val result = numberToText(2012)
        assertThat(result).isEqualTo("dua ribu dua belas")
    }


    @Test
    fun `expect sembilan ratus ribu sembilan puluh sembilan`() {
        val result = numberToText(900099)
        assertThat(result).isEqualTo("sembilan ratus ribu sembilan puluh sembilan")
    }

    @Test
    fun `expect sembilan ratus ribu sembilan ratus sembilan puluh sembilan`() {
        val result = numberToText(900999)
        assertThat(result).isEqualTo("sembilan ratus ribu sembilan ratus sembilan puluh sembilan")
    }

    @Test
    fun `expect sembilan ratus ribu sembilan ribu sembilan ratus sembilan puluh sembilan`() {
        val result = numberToText(909_999)
        assertThat(result).isEqualTo("sembilan ratus sembilan ribu sembilan ratus sembilan puluh sembilan")
    }

    @Test
    fun `expect sembilan ratus sembilan puluh sembilan ribu sembilan ratus sembilan puluh sembilan`() {
        val result = numberToText(999_999)
        assertThat(result).isEqualTo("sembilan ratus sembilan puluh sembilan ribu sembilan ratus sembilan puluh sembilan")
    }
}