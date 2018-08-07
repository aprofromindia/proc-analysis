package com.github.aprofromindia.procanalysis.activities

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.mockito.BDDMockito.given
import org.mockito.Mockito.mock
import java.util.concurrent.CompletableFuture

class ActivityControllerTest {
    private val mockService = mock(ActivityReadService::class.java)
    private val sut = ActivityController(mockService)

    @Test
    fun getTopVariants() {
        // given
        given(mockService.getTopVariants()).willReturn(listOf())

        // when
        val result = sut.getTopVariants()

        //then
        assertThat(result).isInstanceOf(CompletableFuture::class.java)
        assertThat(result.get().content.count()).isEqualTo(0)
    }
}