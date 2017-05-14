import org.example.codekata.kata02.chop
import org.junit.Assert.assertEquals
import org.junit.Test

class Kata02Test {
    @Test fun testChop() {
        assertEquals(-1, chop(target = 3, data = arrayOf()))
        assertEquals(-1, chop(target = 3, data = arrayOf(1)))
        assertEquals(0, chop(target = 1, data = arrayOf(1)))

        assertEquals(0, chop(target = 1, data = arrayOf(1, 3, 5)))
        assertEquals(1, chop(target = 3, data = arrayOf(1, 3, 5)))
        assertEquals(2, chop(target = 5, data = arrayOf(1, 3, 5)))
        assertEquals(-1, chop(target = 0, data = arrayOf(1, 3, 5)))
        assertEquals(-1, chop(target = 2, data = arrayOf(1, 3, 5)))
        assertEquals(-1, chop(target = 4, data = arrayOf(1, 3, 5)))
        assertEquals(-1, chop(target = 6, data = arrayOf(1, 3, 5)))

        assertEquals(0, chop(target = 1, data = arrayOf(1, 3, 5, 7)))
        assertEquals(1, chop(target = 3, data = arrayOf(1, 3, 5, 7)))
        assertEquals(2, chop(target = 5, data = arrayOf(1, 3, 5, 7)))
        assertEquals(3, chop(target = 7, data = arrayOf(1, 3, 5, 7)))
        assertEquals(-1, chop(target = 0, data = arrayOf(1, 3, 5, 7)))
        assertEquals(-1, chop(target = 2, data = arrayOf(1, 3, 5, 7)))
        assertEquals(-1, chop(target = 4, data = arrayOf(1, 3, 5, 7)))
        assertEquals(-1, chop(target = 6, data = arrayOf(1, 3, 5, 7)))
        assertEquals(-1, chop(target = 8, data = arrayOf(1, 3, 5, 7)))
    }
}