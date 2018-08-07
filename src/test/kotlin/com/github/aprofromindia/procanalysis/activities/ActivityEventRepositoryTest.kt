package com.github.aprofromindia.procanalysis.activities

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class ActivityEventRepositoryTest(val param1: List<String>,
                                  val param2: Int) {
    private val sut = ActivityEventRepository()

    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data() = arrayOf(
                arrayOf(listOf("key1", "key1", "key2", "key2", "key2"), 3),
                arrayOf(listOf("key1", "key1", "key2", "key2"), 2),
                arrayOf(listOf("key1", "key1", "key1", "key1", "key2"), 4)
        )
    }


    @Test
    fun getTopVariants() {
        // given
        for (s in param1) {
            sut.save(s)
        }

        // when
        val result = sut.getTopVariants(10)

        // then
        assertThat(result.first().count).isEqualTo(param2)
    }
}