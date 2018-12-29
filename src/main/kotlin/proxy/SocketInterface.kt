package proxy

internal interface SocketInterface {
    fun readLine(): String
    fun writeLine(str: String)
    fun dispose()
}