package org.example.codekata.kata09

class QuantityPricing(var quantity: Int, var basePrice: Double) : PricingScheme {
    override fun calculatePrice(): Double = quantity.toDouble() * basePrice
}