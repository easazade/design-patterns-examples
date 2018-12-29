package proxy

class ProxyImage(private val fileName: String) : Image {

    private var realImage: RealImage? = null

    override fun display() {
        if (realImage == null) {
            realImage = RealImage(fileName)
        }
        //TODO we can do some additional work in these functions
        realImage!!.display()
    }
}