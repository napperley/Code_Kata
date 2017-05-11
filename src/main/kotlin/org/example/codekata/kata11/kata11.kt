@file:Suppress("unused")

package org.example.codekata.kata11

internal fun printSortedBalls() {
    val rack = mutableListOf<Int>()

    rack += 20
    rack += 10
    rack += 30
    println("Sorted Balls:")
    sortBalls(rack.toTypedArray()).forEach { println("  $it") }
}

internal fun printSortedCharacters() {
    val originalStr = "When not studying nuclear physics, Bambi likes to play beach volleyball."

    println("Original String: $originalStr")
    println("Sorted String: ${originalStr.sortedCharacters()}")
}

fun String.sortedCharacters(): String {
    val builder = StringBuilder()
    val chars = this.toCharArray()
            .filter { it.isLetter() }
            .map { it.toLowerCase() }
            .groupBy { it }

    ('a'..'z').forEach { letter ->
        builder.append(letter.multiply(chars[letter]?.size ?: 0))
    }
    return builder.toString()
}

fun Char.multiply(num: Int): String {
    val builder = StringBuilder()

    if (num > 0) (1..num).forEach { builder.append(this) }
    return builder.toString()
}

fun sortBalls(rack: Array<Int>) = rack.sortedArray()