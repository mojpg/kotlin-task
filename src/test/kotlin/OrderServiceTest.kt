import org.junit.jupiter.api.Assertions.*
import OrderService
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class OrderServiceTest {
    private val orderService = OrderService()

    @Test
    fun `Three apples and one orange should be 1-45`() {
        val testInput = listOf("Apple", "Apple", "Apple", "Orange")
        val expectedOutput = 1.45
        val actualOutput = orderService.calculateOrderPrice(testInput, 3, 1)
        assertEquals(expectedOutput, actualOutput)
    }

    @Test
    fun `Four apples and three oranges should be 1-70`() {
        val testInput = listOf("Apple", "Apple", "Apple", "Apple", "Orange", "Orange", "Orange")
        val expectedOutput = 1.70
        val actualOutput = orderService.calculateOrderPrice(testInput, 4, 3)
        assertEquals(expectedOutput, actualOutput)
    }

    @Test
    fun `Invalid items should throw an exception`() {
        val testInput = listOf("Banana")
        val exception = assertThrows<Exception>("Unexpected value!") {
            orderService.calculateOrderPrice(testInput, 1, 1)
        }
        val expectedMessage = "Unexpected value!"
        val actualMessage = exception.message
        actualMessage?.contains(expectedMessage)?.let { assertTrue(it) }

    }
}