#!/usr/bin/env groovy

def printSystemMetrics() {
    def command = "top -b -n 1"
    def process = command.execute()
    process.waitFor()

    def output = process.text
    def lines = output.readLines()

    def cpuUsage = lines.find { it.startsWith("%Cpu(s):") }
    def memoryUsage = lines.find { it.startsWith("MiB Mem :") }

    def formattedCpuUsage = cpuUsage.replaceAll("%Cpu\\(s\\):\\s+", "").replaceAll(",", ".")
    def formattedMemoryUsage = memoryUsage.replaceAll("MiB Mem :", "").replaceAll(",", ".")

    println "==== System Metrics ===="
    println "CPU Usage: ${formattedCpuUsage}"
    println "Memory Usage: ${formattedMemoryUsage}"
}

printSystemMetrics()