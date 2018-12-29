package proxy

import java.util.*


fun main(args: Array<String>) {
    // 3. The client deals with the wrapper
    val socket = SocketProxy("127.0.0.1", 8080, args[0] == "first")
    var str: String
    var skip = true
    while (true) {
        if (args[0] == "second" && skip) {
            skip = !skip
        } else {
            str = socket.readLine()
            println("Receive - $str")
            if (str == null) {
                break
            }
        }
        print("Send ---- ")
        str = Scanner(System.`in`).nextLine()
        socket.writeLine(str)
        if (str == "quit") {
            break
        }
    }
    socket.dispose()
}