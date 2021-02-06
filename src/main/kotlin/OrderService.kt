class OrderService {
    private val applePrice = 0.60
    private val orangePrice = 0.25

    fun calculateOrderPrice(order: List<String>): Double {
        var total = 0.0
        for (item in order) {
            if (item == "Orange") {
                total += orangePrice
            }
            else if (item == "Apple") {
                total += applePrice
            }
            else {
                throw Exception("Unexpected value!")
            }
        }
        return total
    }

}