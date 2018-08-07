package com.github.aprofromindia.procanalysis.activities

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized
import org.mockito.BDDMockito.anyString
import org.mockito.BDDMockito.given
import org.mockito.Mockito.mock
import java.time.LocalDateTime


@RunWith(Parameterized::class)
class ActivityWriteServiceTest internal constructor(val param1: Boolean,
                                                    val param2: List<Activity>,
                                                    val param3: Boolean) {
    private val mockRepo = mock(ActivityEventRepository::class.java)
    private val sut = ActivityWriteService(mockRepo)

    companion object {

        @JvmStatic
        @Parameterized.Parameters
        fun data(): Array<Array<Any>> = arrayOf(
                arrayOf(true, listOf<Activity>(), true),
                arrayOf(false, listOf<Activity>(), false),
                arrayOf(true, listOf(
                        Activity("1", "", LocalDateTime.now()),
                        Activity("1", "name", LocalDateTime.now())
                ), true)
        )
    }

    @Test
    fun saveActivities() {
        // given
        given(mockRepo.save(anyString())).willReturn(param1)

        // when
        val result = sut.saveActivities(param2)

        // then
        assertThat(result).isEqualTo(param3)
    }
}