package objectpool

class BatteryChargerDock {

    private val mObjectPool = object : ObjectPool<Battery>() {
        override fun create(): Battery = Battery()
        override fun validate(o: Battery?): Boolean = o?.isDead()?.not() ?: false
        override fun expire(o: Battery?) {
            o?.discardBattery()
        }

        override fun onObjectIsBackInPool(o: Battery) {
            o.connectCharger()
        }

        override fun onObjectIsOutOfThePool(o: Battery) {
            o.disConnectCharger()
        }
    }

    fun plugin(battery: Battery) {
        mObjectPool.throwInPool(battery)
    }

    fun getOneBattery() = mObjectPool.getFromPool()


}