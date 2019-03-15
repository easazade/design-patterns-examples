package objectpool

class Battery {

    private val created = System.currentTimeMillis()

    var isCharging: Boolean = false
        private set(value) {
            field = value
        }

    fun connectCharger() {
        isCharging = true
        println("connecting charger")
    }

    fun disConnectCharger() {
        isCharging = false
        println("disconnecting charger")
    }

    fun hasEnoughCharge(): Boolean {
        println("battery has enough charge")
        return true
    }

    fun isDead() = System.currentTimeMillis() - created > 300000

    fun discardBattery() {
        println("discarding battery")
    }

}