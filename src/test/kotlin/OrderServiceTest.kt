import org.junit.jupiter.api.Assertions.*
import OrderService
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class OrderServiceTest {
    private val orderService = OrderService()

    @Test
    fun `Three apples and one orange should be 2-05`() {
        val testInput = listOf("Apple", "Apple", "Apple", "Orange")
        val expectedOutput = 2.05
        val actualOutput = orderService.calculateOrderPrice(testInput)
        assertEquals(actualOutput, expectedOutput)
    }

    @Test
    fun `Invalid items should throw an exception`() {
        val testInput = listOf("Banana")
        val exception = assertThrows<Exception>("Unexpected value!") {
            orderService.calculateOrderPrice(testInput)
        }
        val expectedMessage = "Unexpected value!"
        val actualMessage = exception.message
        actualMessage?.contains(expectedMessage)?.let { assertTrue(it) }

    }
}