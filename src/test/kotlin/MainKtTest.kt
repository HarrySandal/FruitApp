import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class MainKtTest {

    @Test
    fun offerOnApple () {
        assertEquals(4, offerOnApple(2))
    }

    @Test
    fun offerOnOrange() {
        assertEquals(3, offerOnOrange(2))
    }

    @Test
    fun fruit() {
        assertEquals(3.6,fruit(6,.60))
        assertEquals(0.25,fruit(1,.25))
    }

}