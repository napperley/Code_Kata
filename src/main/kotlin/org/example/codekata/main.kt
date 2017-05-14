package org.example.codekata

import org.example.codekata.kata09.Item
import org.example.codekata.kata09.QuantityPricing
import java.text.DecimalFormat

fun main(args: Array<String>) {
    val numFormat = DecimalFormat("#.00")
    val pricing = QuantityPricing(quantity = 3, basePrice = 1.20)
    val item = Item("Banana", pricing)

    println("${item.name} price: ${numFormat.format(item.price)}")
    pricing.quantity = 7
    println("${item.name} price: ${numFormat.format(item.price)}")
}