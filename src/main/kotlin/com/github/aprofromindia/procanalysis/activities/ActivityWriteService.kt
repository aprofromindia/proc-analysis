package com.github.aprofromindia.procanalysis.activities

import org.springframework.stereotype.Service

@Service
internal class ActivityWriteService(private val repository: ActivityEventRepository) {
    fun saveActivities(activities: List<Activity>): Boolean {
        val currentKey = StringBuilder()
        for (act in activities) {
            currentKey.append("${act.name.trim()}, ")
        }
        return repository.save(currentKey.toString())
    }
}