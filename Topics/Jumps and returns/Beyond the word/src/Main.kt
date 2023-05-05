fun main() {
    val word = readln()
    for (ch in 'a'..'z') {
        if (ch in word) continue
        print(ch)
    }
}