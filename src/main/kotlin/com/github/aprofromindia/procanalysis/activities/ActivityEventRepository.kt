package com.github.aprofromindia.procanalysis.activities

import org.springframework.cache.annotation.CacheEvict
import org.springframework.cache.annotation.Cacheable
import org.springframework.stereotype.Repository
import java.util.*
import kotlin.math.min

private const val CACHE_KEY = "top10"

@Repository
internal class ActivityEventRepository {
    private val map = hashMapOf<String, Int>()
    private val heap = PriorityQueue<ActivityEvent> { o1, o2 -> o2.count.compareTo(o1.count) }

    @Cacheable(CACHE_KEY)
    fun getTopVariants(size: Int): List<ActivityEvent> {
        val list = List(min(size, heap.size)) { heap.remove() }
        heap.addAll(list)
        return list
    }

    @CacheEvict(CACHE_KEY, allEntries = true)
    fun save(event: String): Boolean {
        val num = map.getOrDefault(event, 0)
        if (num != 0) heap.remove(ActivityEvent(event, num))
        map[event] = num + 1
        return heap.add(ActivityEvent(event, map[event]!!))
    }
}