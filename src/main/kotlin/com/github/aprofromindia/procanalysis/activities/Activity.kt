package com.github.aprofromindia.procanalysis.activities

import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.annotation.JsonProperty
import java.time.LocalDateTime

internal data class Activity(
        @JsonProperty("CaseId") val caseId: String,
        @JsonProperty("ActivityName") val name: String,
        @JsonProperty("Timestamp")
        @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS") val timeStamp: LocalDateTime)

internal data class ActivityEvent(val key: String, val count: Int)