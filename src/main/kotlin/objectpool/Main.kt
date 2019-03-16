package objectpool

fun main(args: Array<String>) {
    /*
    each battery creates 1 second to get created so we are using an object pool
    this way we don't have to use a new battery every single time we need one we use already created ones
     */


    val chargerDock = BatteryChargerDock()

    val battery1 = chargerDock.getOneBattery()
    val battery2 = chargerDock.getOneBattery()
    val battery3 = chargerDock.getOneBattery()
    val battery4 = chargerDock.getOneBattery()

    chargerDock.plugin(battery1)
    chargerDock.plugin(battery2)
    chargerDock.plugin(battery3)

}


