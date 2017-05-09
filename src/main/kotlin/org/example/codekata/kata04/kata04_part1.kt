package org.example.codekata.kata04

import java.io.File

@Suppress("unused")
internal fun printSmallestSpread() {
    val fileUri = "".javaClass.getResource("/kata04_data/weather.dat").toURI()
    val data = fetchData(File(fileUri))
    val smallest: TemperatureModel? = createModels(data).minBy { it.spread }

    println("""
        |Day with smallest temperature spread: ${smallest?.day}
        |  Min Temp: ${smallest?.min}
        |  Max Temp: ${smallest?.max}
        """.trimMargin())
}

private fun createModels(data: Array<Array<String>>): Array<TemperatureModel> {
    val minPos = 1
    val maxPos = 0
    val models = mutableListOf<TemperatureModel>()

    data.forEachIndexed { index, item ->
        // Temporarily store an array of temperatures.
        val tmp = item.map { str -> convertToTemperature(str) }

        models += TemperatureModel(day = index + 1, min = tmp[minPos], max = tmp[maxPos])
    }
    return models.toTypedArray()
}

private fun convertToTemperature(str: String) = str.replace(oldValue = "*", newValue = "").toDouble()

private fun fetchData(txtFile: File): Array<Array<String>> = txtFile.readLines()
        .drop(2)
        .map { processLine(it) }
        .toTypedArray()

private fun processLine(line: String): Array<String> = line.split(delimiters = ' ')
        .filter { it.isNotEmpty() }
        .drop(1)
        .take(2)
        .toTypedArray()