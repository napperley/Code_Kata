package org.example.codekata.kata09

data class Item(
    var name: String,
    var pricingScheme: PricingScheme
) {
    val price
        get() = pricingScheme.calculatePrice()
}