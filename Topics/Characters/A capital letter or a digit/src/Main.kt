fun main() {
    val char = readln().first()

    print(char.isUpperCase() || char.isDigit() && char.digitToInt() in 1..9)
}