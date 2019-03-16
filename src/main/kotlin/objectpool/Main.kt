package objectpool

fun main(args: Array<String>) {
    /*
    each battery creates 1 second to get created
    --------------------------------------------
    Object pools (otherwise known as resource pools) are used to manage the object caching.
    A client with access to a Object pool can avoid creating a new Objects by simply asking the pool for
    one that has already been instantiated instead. Generally the pool will be a growing pool, i.e. the
    pool itself will create new objects if the pool is empty, or we can have a pool, which restricts
    the number of objects created.
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


