import junit.framework.TestCase.assertEquals
import org.example.codekata.kata13.countCodeLines
import org.junit.Test
import java.io.File

class Kata13Test {
    @Test fun testCountCodeLines() {
        val daveUri = "".javaClass.getResource("/kata13_data/Dave.java").toURI()
        val helloUri = "".javaClass.getResource("/kata13_data/Hello.java").toURI()

        assertEquals(3, countCodeLines(File(daveUri)))
        assertEquals(5, countCodeLines(File(helloUri)))
    }
}