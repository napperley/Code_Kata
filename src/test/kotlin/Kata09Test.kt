import junit.framework.TestCase.assertEquals
import org.example.codekata.kata09.*
import org.junit.Test
import java.text.DecimalFormat

class Kata09Test {
    @Test fun testPricing() {
        val numFormat = DecimalFormat("#.00")

        assertEquals(3.44,
                numFormat.format(QuantityPricing(quantity = 1, basePrice = 3.44).calculatePrice()).toDouble())
        assertEquals(3.6,
                numFormat.format(QuantityPricing(quantity = 3, basePrice = 1.20).calculatePrice()).toDouble())
        assertEquals(0.6, numFormat.format(
                WeightPricing(basePrice = 0.20, weightType = Weight.kg, amount = 3000.0).calculatePrice()).toDouble())
    }

    @Test fun testCheckoutTotal() {
        val numFormat = DecimalFormat("#.00")

        checkoutItems += Item("Banana", QuantityPricing(quantity = 3, basePrice = 1.20))
        assertEquals(3.6, numFormat.format(checkoutTotal()).toDouble())
        checkoutItems += Item("White Flour", WeightPricing(basePrice = 0.20, weightType = Weight.kg, amount = 3000.0))
        assertEquals(4.2, numFormat.format(checkoutTotal()).toDouble())
        checkoutItems += Item("Muesli", QuantityPricing(quantity = 1, basePrice = 3.44))
        assertEquals(7.64, numFormat.format(checkoutTotal()).toDouble())
    }
}