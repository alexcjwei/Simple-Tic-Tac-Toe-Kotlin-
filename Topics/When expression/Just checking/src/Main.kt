fun main() {

    println(when(readln().toInt()) {
        2 -> "Yes!"
        !in 1..4 -> "Unknown number"
        else -> "No!"
    })

}