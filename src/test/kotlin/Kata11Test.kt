import junit.framework.TestCase.assertEquals
import org.example.codekata.kata11.multiply
import org.example.codekata.kata11.sortedCharacters
import org.junit.Test

class Kata11Test {
    @Test fun testMultiplyCharacters() {
        assertEquals("AAAAA", 'A'.multiply(5))
    }

    @Test fun testSortedCharacters() {
        val originalStr = "When not studying nuclear physics, Bambi likes to play beach volleyball."
        val sortedStr = "aaaaabbbbcccdeeeeeghhhiiiiklllllllmnnnnooopprsssstttuuvwyyyy"

        assertEquals(sortedStr, originalStr.sortedCharacters())
    }
}