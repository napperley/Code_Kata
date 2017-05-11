package org.example.codekata.kata09

/**
 * Calculates price based on weight. [Amount][amount] is specified in grams (g).
 */
class WeightPricing(var weightType: Weight, var amount: Double, var basePrice: Double) : PricingScheme {
    override fun calculatePrice(): Double = when (weightType) {
        Weight.mg -> (amount * 1000) * basePrice
        Weight.g -> amount * basePrice
        Weight.kg -> (amount / 1000) * basePrice
    }
}