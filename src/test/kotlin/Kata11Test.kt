import junit.framework.TestCase.assertEquals
import org.example.codekata.kata11.duplicate
import org.example.codekata.kata11.sortedCharacters
import org.junit.Test

class Kata11Test {
    @Test fun testDuplicateCharacter() {
        assertEquals("AAAAA", 'A'.duplicate(5))
    }

    @Test fun testSortedCharacters() {
        val originalStr = "When not studying nuclear physics, Bambi likes to play beach volleyball."
        val sortedStr = "aaaaabbbbcccdeeeeeghhhiiiiklllllllmnnnnooopprsssstttuuvwyyyy"

        assertEquals(sortedStr, originalStr.sortedCharacters())
    }
}