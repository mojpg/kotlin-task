import OrderService
import CustomerNotificationService
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.*

fun main(args: Array<String>): Unit = runBlocking {
    if (args.isEmpty()) {
        print("No arguments found. Please provide a list of strings.")
    }
    val channel = Channel<Double>()
    val orderList = args[0].split(',')
    val orderService = OrderService()
    val customerNotificationService = CustomerNotificationService()
    launch {
        channel.send(orderService.calculateOrderPrice(orderList))
    }

    launch {
        customerNotificationService.announceEvent(channel.receive())
    }
}

// reasonable assumption about input: comma-separated list of items in the form:
// Apple,Apple,Orange... etc.