package org.example.codekata

import org.example.codekata.kata09.*
import java.text.DecimalFormat

fun main(args: Array<String>) {
    val numFormatter = DecimalFormat("#.00")

    checkoutItems += Item("Banana", QuantityPricing(quantity = 3, basePrice = 1.20))
    checkoutItems += Item("White Flour", WeightPricing(basePrice = 0.20, weightType = Weight.kg, amount = 3000.0))
    checkoutItems += Item("Muesli", QuantityPricing(quantity = 1, basePrice = 3.44))
    checkoutItems.forEach { println("Checkout Item: ${it.name}") }
    println("Checkout Total: ${numFormatter.format(checkoutTotal())}")
}