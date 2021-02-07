

class CustomerNotificationService {
    fun announceEvent(received: Double?) {
        if (received == null) {
            print("Your order failed due to limited stock. Please try again.")
        }
        else {
            print("Received order of value $$received, estimated delivery in a week.")
        }
    }

}

