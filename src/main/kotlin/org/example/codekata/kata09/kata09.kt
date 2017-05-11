package org.example.codekata.kata09

val checkoutItems = mutableListOf<Item>()

fun checkoutTotal() = checkoutItems.sumByDouble { it.price }