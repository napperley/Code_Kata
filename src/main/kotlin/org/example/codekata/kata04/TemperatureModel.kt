package org.example.codekata.kata04

internal data class TemperatureModel(val day: Int, val min: Double, val max: Double) {
    val spread by lazy { min + max }
}