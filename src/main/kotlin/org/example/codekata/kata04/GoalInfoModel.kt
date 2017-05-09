package org.example.codekata.kata04

data class GoalInfoModel(val forGoals: Int, val againstGoals: Int, val teamName: String) {
    val goalDifference by lazy { forGoals - againstGoals }
}