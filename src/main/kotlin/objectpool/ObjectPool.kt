package objectpool

import java.util.*


abstract class ObjectPool<T>(private val objectExpirationTimeInMillis: Long = -1) {

    private val locked: Hashtable<T, Long> = Hashtable()
    private val unlocked: Hashtable<T, Long> = Hashtable()

    protected abstract fun create(): T

    abstract fun validate(o: T?): Boolean

    abstract fun expire(o: T?)

    open fun onObjectIsOutOfThePool(o: T) {}

    open fun onObjectIsBackInPool(o: T) {}

    @Synchronized
    fun getFromPool(): T {
        val now = System.currentTimeMillis()
        var t: T?
        if (unlocked.size > 0) {
            val e = unlocked.keys()
            while (e.hasMoreElements()) {
                t = e.nextElement()
                if (objectExpirationTimeInMillis != -1L && now - unlocked[t]!! > objectExpirationTimeInMillis) {
                    // object has expired
                    unlocked.remove(t)
                    expire(t)
                    t = null
                } else {
                    if (validate(t)) {
                        unlocked.remove(t)
                        locked[t] = now
                        onObjectIsOutOfThePool(t)
                        return t
                    } else {
                        // object failed validation
                        unlocked.remove(t)
                        expire(t)
                        t = null
                    }
                }
            }
        }
        // no objects available, create a new one
        t = create()
        locked[t] = now
        onObjectIsOutOfThePool(t)
        return t
    }

    @Synchronized
    fun throwInPool(t: T) {
        locked.remove(t)
        unlocked[t] = System.currentTimeMillis()
        onObjectIsBackInPool(t)
    }
}