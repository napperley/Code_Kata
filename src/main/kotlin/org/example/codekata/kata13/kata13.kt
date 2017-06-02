package org.example.codekata.kata13

import java.io.File

@Suppress("VARIABLE_WITH_REDUNDANT_INITIALIZER")
fun countCodeLines(srcFile: File): Int {
    var result = 0
    val lines = mutableListOf<String>()

    srcFile.forEachLine { l ->
        lines += l.trim()
    }
    result = lines
        .filterNot { it.startsWith(prefix = "//") }
        .filterNot { it.startsWith(prefix = "/*") }
        .filterNot { it.startsWith(prefix = "*/") }
        .filterNot { it.startsWith(prefix = "*") }
        .filterNot { it.isEmpty() }
        .size
    return result
}