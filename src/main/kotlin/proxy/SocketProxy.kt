package proxy

import java.io.IOException
import java.io.PrintWriter
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.Socket
import java.net.ServerSocket


internal class SocketProxy(host: String, port: Int, wait: Boolean) : SocketInterface {
    // 1. Create a "wrapper" for a remote,
    // or expensive, or sensitive target
    private var socket: Socket? = null
    private var `in`: BufferedReader? = null
    private var out: PrintWriter? = null

    init {
        try {
            socket = if (wait) {
                // 2. Encapsulate the complexity/overhead of the target in the wrapper
                val server = ServerSocket(port)
                server.accept()
            } else {
                Socket(host, port)
            }
            `in` = BufferedReader(InputStreamReader(socket!!.getInputStream()))
            out = PrintWriter(socket!!.getOutputStream(), true)
        } catch (e: IOException) {
            e.printStackTrace()
        }

    }

    override fun readLine(): String {
        var str: String? = null
        try {
            str = `in`!!.readLine()
        } catch (e: IOException) {
            e.printStackTrace()
        }

        return str!!
    }

    override fun writeLine(str: String) {
        // 4. The wrapper delegates to the target
        out!!.println(str)
    }

    override fun dispose() {
        try {
            socket!!.close()
        } catch (e: IOException) {
            e.printStackTrace()
        }

    }
}