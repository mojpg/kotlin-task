import kotlin.math.ceil

class OrderService {
    private val applePrice = 0.60
    private val orangePrice = 0.25

    fun calculateOrderPrice(order: List<String>): Double {
        var total = 0.0
        var orangeCount = 0
        var appleCount = 0
        for (item in order) {
            if (item == "Orange") {
                orangeCount += 1
            }
            else if (item == "Apple") {
                appleCount += 1
            }
            else {
                throw Exception("Unexpected value!")
            }
        }
        val discountedAppleCount = ceil((appleCount.toDouble()/2))
        print(discountedAppleCount)
        val discountedOrangeCount = ceil(((orangeCount.toDouble()/3)*2))
        total = discountedAppleCount*applePrice + discountedOrangeCount*orangePrice
        return total
    }

}