package com.github.aprofromindia.procanalysis.activities

import org.springframework.stereotype.Service

private const val DEFAULT_SIZE = 10

@Service
internal class ActivityReadService(private val repository: ActivityEventRepository) {
    fun getTopVariants(num: Int = DEFAULT_SIZE) = repository.getTopVariants(num)
}
