package org.example.codekata.kata06

import java.io.File

internal fun printAnagrams() {
    val fileUri = "".javaClass.getResource("/kata06_data/word_list.txt").toURI()
    val data = fetchData(File(fileUri))
    val anagrams = createAnagrams(data)
    val limit = 50

    println("Anagrams:")
    anagrams.filter { it.contains(char = ' ') }.take(limit).forEach { println(it) }
}

fun createAnagrams(data: Array<String>): Array<String> {
    val anagrams = mutableListOf<String>()

    data.forEachIndexed { pos, w1 ->
        anagrams += w1
        data.filter { w2 -> w2.length == w1.length && w2 != w1 }.forEach { w2 ->
            if (isAnagram(w1, w2)) anagrams[pos] += " $w2"
        }
    }
    return anagrams.toTypedArray()
}

private fun fetchData(txtFile: File): Array<String> {
    val lines = mutableListOf<String>()
    val limit = 1000

    txtFile.forEachLine { l ->
        lines += l.replace(oldValue = "'", newValue = "")
    }
    // Place a limit otherwise the program will hang.
    return lines.take(limit).toTypedArray()
}

private fun isAnagram(word1: String, word2: String) =
        word1.toLowerCase().toList().sorted() == word2.toLowerCase().toList().sorted()
