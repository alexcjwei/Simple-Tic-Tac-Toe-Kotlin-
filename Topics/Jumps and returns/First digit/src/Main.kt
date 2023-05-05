fun main() {
    val chars = readln().toCharArray()
    for (ch in chars) {
        if (ch.isDigit()) {
            println(ch)
            return
        }
    }
}