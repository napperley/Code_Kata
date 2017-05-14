package org.example.codekata.kata06

import java.io.File

@Suppress("unused")
internal fun printAnagrams() {
    val fileUri = "".javaClass.getResource("/kata06_data/word_list.txt").toURI()
    val data = fetchData(File(fileUri))
    val anagrams = allAnagrams(data)
    val limit = 10

    println("\nAnagrams:")
    anagrams.take(limit).forEach { println(it) }
}

private fun allAnagrams(data: Array<String>): Array<String> {
    val anagrams = mutableListOf<String>()
    val possibleWords = data.toMutableList()

    println("Creating anagrams...")
    data.forEach { w ->
        val tmpAnagram = createAnagram(w, possibleWords.toTypedArray())

        if (tmpAnagram.isNotEmpty()) {
            anagrams += tmpAnagram
            possibleWords.removeAll(tmpAnagram.split(delimiters = ' '))
        }
    }
    return anagrams.toTypedArray()
}

fun createAnagram(word: String, possibleWords: Array<String>): String {
    val builder = StringBuilder(word)

    possibleWords.filter { pw -> pw.length == word.length }
            .filterNot { pw -> pw.equals(other = word, ignoreCase = true) }
            .forEach { pw -> if (isAnagram(word, pw)) builder.append(" $pw") }
    return if (' ' in builder.toString()) builder.toString() else ""
}

private fun fetchData(txtFile: File): Array<String> {
    val lines = mutableListOf<String>()
    val limit = 20000
    val minLength = 2

    println("Reading data from text file...")
    txtFile.forEachLine { if (it.length >= minLength) lines += it.replace(oldValue = "'", newValue = "") }
    // Place a limit otherwise the program will hang.
    return lines.take(limit).toTypedArray()
}

fun isAnagram(word1: String, word2: String) =
        word1.toLowerCase().toList().sorted() == word2.toLowerCase().toList().sorted()
