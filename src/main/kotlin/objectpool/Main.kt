package objectpool

fun main(args: Array<String>) {

    val chargerDock = BatteryChargerDock()

    val battery1 = chargerDock.getOneBattery()
    val battery2 = chargerDock.getOneBattery()
    val battery3 = chargerDock.getOneBattery()
    val battery4 = chargerDock.getOneBattery()

    chargerDock.plugin(battery1)
    chargerDock.plugin(battery2)
    chargerDock.plugin(battery3)

}


