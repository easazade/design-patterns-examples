package proxy


    fun main(args: Array<String>) {
        val image = ProxyImage("test_10mb.jpg")

        //image will be loaded from disk
        image.display()
        println("")

        //image will not be loaded from disk
        image.display()
    }