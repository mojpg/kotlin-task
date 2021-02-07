import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import java.io.ByteArrayOutputStream
import java.io.PrintStream

internal class CustomerNotificationServiceTest {

    private var testOutputStream = ByteArrayOutputStream()
    private var originalOutputStream = System.out
    private var customerNotificationService = CustomerNotificationService()

    @BeforeEach
    fun setStreams() {
        System.setOut(PrintStream(testOutputStream))
    }

    @AfterEach
    fun restoreStreams() {
        System.setOut(originalOutputStream)
    }

    @Test
    fun `announce events to the console`() {
        customerNotificationService.announceEvent(2.05)
        assertEquals("Received order of value $2.05, estimated delivery in a week.", testOutputStream.toString())
    }
}