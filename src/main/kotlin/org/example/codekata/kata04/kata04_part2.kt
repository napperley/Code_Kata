package org.example.codekata.kata04

import java.io.File

@Suppress("unused")
internal fun printSmallestGoals() {
    val fileUri = "".javaClass.getResource("/kata04_data/football.dat").toURI()
    val data = fetchData(File(fileUri))
    val smallest: GoalInfoModel? = createModels(data).filter { it.goalDifference >= 0 }.minBy { it.goalDifference }

    println("""
        |Team with smallest goal difference: ${smallest?.teamName}
        |   For Goals - ${smallest?.forGoals}
        |   Against Goals - ${smallest?.againstGoals}
        |   Goal Difference - ${smallest?.goalDifference}
        """.trimMargin())
}

private fun fetchData(txtFile: File): Array<Array<String>> = txtFile.readLines()
        .drop(1)
        .filter { !it.contains("--") }
        .map { processLine(it) }
        .toTypedArray()

private fun processLine(line: String): Array<String> {
    val tmp = line.split(delimiters = " ").filter { it.isNotEmpty() }.drop(1).dropLast(1)
    val teamPos = 0
    val forPos = 5
    val againstPos = 7

    return arrayOf(tmp[teamPos], tmp[forPos], tmp[againstPos])
}

private fun createModels(data: Array<Array<String>>): Array<GoalInfoModel> {
    val teamPos = 0
    val forPos = 1
    val againstPos = 2
    val models = mutableListOf<GoalInfoModel>()

    data.forEach { item ->
        models += GoalInfoModel(teamName = item[teamPos], forGoals = item[forPos].toInt(),
                againstGoals = item[againstPos].toInt())
    }
    return models.toTypedArray()
}