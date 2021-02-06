import OrderService

fun main(args: Array<String>) {
    if (args.isEmpty()) {
        print("No arguments found. Please provide a list of strings.")
    }
    val orderList = args[0].split(',')
    val orderService = OrderService()

    val orderPrice = orderService.calculateOrderPrice(orderList)

    print("Order price is $$orderPrice")
}

// reasonable assumption about input: comma-separated list of items in the form:
// Apple,Apple,Orange... etc.