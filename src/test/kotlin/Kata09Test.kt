import junit.framework.TestCase.assertEquals
import org.example.codekata.kata09.*
import org.junit.Test
import java.text.DecimalFormat

class Kata09Test {
    @Test fun testCalculatePrice() {
        val numFormat = DecimalFormat("#.00")

        assertEquals(3.44,
                numFormat.format(QuantityPricing(quantity = 1, basePrice = 3.44).calculatePrice()).toDouble())
        assertEquals(3.60,
                numFormat.format(QuantityPricing(quantity = 3, basePrice = 1.20).calculatePrice()).toDouble())
        assertEquals(0.60, numFormat.format(
                WeightPricing(basePrice = 0.20, weightType = Weight.kg, amount = 3000.0).calculatePrice()).toDouble())
    }

    @Test fun changeItemPrice() {
        val numFormat = DecimalFormat("#.00")
        val pricing = QuantityPricing(quantity = 3, basePrice = 1.20)
        val item = Item("Banana", pricing)

        assertEquals(3.60, numFormat.format(item.price).toDouble())
        pricing.quantity = 7
        assertEquals(8.40, numFormat.format(item.price).toDouble())
    }

    @Test fun testCheckoutTotal() {
        val numFormat = DecimalFormat("#.00")

        checkoutItems += Item("Banana", QuantityPricing(quantity = 3, basePrice = 1.20))
        assertEquals(3.60, numFormat.format(checkoutTotal()).toDouble())
        checkoutItems += Item("White Flour", WeightPricing(basePrice = 0.20, weightType = Weight.kg, amount = 3000.0))
        assertEquals(4.20, numFormat.format(checkoutTotal()).toDouble())
        checkoutItems += Item("Muesli", QuantityPricing(quantity = 1, basePrice = 3.44))
        assertEquals(7.64, numFormat.format(checkoutTotal()).toDouble())
    }
}