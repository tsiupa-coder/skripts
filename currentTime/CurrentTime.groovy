#!/usr/bin/env groovy

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

def displayCurrentTime() {
    LocalDateTime currentTime = LocalDateTime.now()
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE, MMMM d, yyyy HH:mm")
    String formattedTime = currentTime.format(formatter)
    println "Current time is: ${formattedTime}"
}

displayCurrentTime()