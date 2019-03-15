package proxy

class ProxyImage(private val fileName: String) : Image {

    private var realImage: RealImage? = null

    init {
        println("creating proxy image")
    }

    override fun display() {
        if (realImage == null) {
            realImage = RealImage(fileName)
        }
        //TODO we can do some additional work in these functions
        print("doing some additional stuff in display method of proxy - ")
        realImage!!.display()
    }


}