package com.github.aprofromindia.procanalysis.home

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.springframework.hateoas.Resource

class HomeControllerTest {
    private val sut = HomeController()

    @Test
    fun index() {
        // given

        // when
        val result = sut.index()

        // then
        assertThat(result).isInstanceOf(Resource::class.java)
        assertThat(result.content).isEqualToIgnoringCase("Welcome to Process Analytics!")
    }
}