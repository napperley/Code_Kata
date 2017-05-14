import junit.framework.TestCase.assertEquals
import org.example.codekata.kata06.createAnagram
import org.example.codekata.kata06.isAnagram
import org.junit.Test

class Kata06Test {
    @Test fun testIsAnagram() {
        val word = "silent"
        val possibleWords = arrayOf("enlist", "refresh", "listen", "sort")

        assertEquals(true, isAnagram(word, possibleWords[0]))
        assertEquals(false, isAnagram(word, possibleWords[1]))
        assertEquals(true, isAnagram(word, possibleWords[2]))
        assertEquals(false, isAnagram(word, possibleWords[3]))
    }

    @Test fun testCreateAnagram() {
        val word1 = "silent"
        val word2 = "den"
        val possibleWords = arrayOf("enlist", "refresh", "listen", "sort")

        assertEquals("silent enlist listen", createAnagram(word1, possibleWords))
        assertEquals("", createAnagram(word2, possibleWords))
    }
}