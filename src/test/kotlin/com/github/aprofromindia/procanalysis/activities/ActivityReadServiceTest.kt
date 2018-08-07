package com.github.aprofromindia.procanalysis.activities

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.mockito.BDDMockito.given
import org.mockito.Mockito.anyString
import org.mockito.Mockito.mock

class ActivityReadServiceTest {
    private val repo = mock(ActivityEventRepository::class.java)
    private val sut = ActivityReadService(repo)

    @Test
    fun getTopVariants() {
        // given
        given(repo.save(anyString())).willReturn(true)

        // when
        val result = sut.getTopVariants()

        // then
        assertThat(result).isInstanceOf(List::class.java)
    }
}