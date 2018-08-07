package com.github.aprofromindia.procanalysis

import com.fasterxml.jackson.dataformat.csv.CsvMapper
import com.fasterxml.jackson.dataformat.csv.CsvSchema
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import com.github.aprofromindia.procanalysis.activities.Activity
import com.github.aprofromindia.procanalysis.activities.ActivityWriteService
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
internal class ProcAnalysisApplication {

    @Bean
    fun setup(writeService: ActivityWriteService) = CommandLineRunner { _ ->
        var currentId = ""
        val activities = arrayListOf<Activity>()

        val readActivities = CsvMapper().registerModule(JavaTimeModule())
                .readerFor(Activity::class.java)
                .with(CsvSchema.builder().setColumnSeparator(';').setUseHeader(true).build())
                .readValues<Activity>(javaClass.classLoader
                        .getResource("Activity_Log_2004_to_2014.csv"))
                .readAll()

        for (i in readActivities.indices) {
            val activity = readActivities.get(i)
            if (currentId == "") currentId = activity.caseId
            if (currentId != activity.caseId) {
                writeService.saveActivities(activities)
                activities.clear()
                currentId = activity.caseId
            }
            activities.add(activity)
            if (i == readActivities.size - 1) writeService.saveActivities(activities)
        }
    }
}

fun main(args: Array<String>) {
    runApplication<ProcAnalysisApplication>(*args)
}
