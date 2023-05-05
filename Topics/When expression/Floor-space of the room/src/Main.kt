import kotlin.math.pow
import kotlin.math.sqrt

const val PI = 3.14


fun main() {
    val area = when(readln()) {
        "triangle" -> {
            val a = readln().toDouble()
            val b = readln().toDouble()
            val c = readln().toDouble()
            val s = (a + b + c) / 2
            sqrt(s * (s - a) * (s - b) * (s - c))
        }
        "rectangle" -> {
            val height = readln().toDouble()
            val width = readln().toDouble()
            height * width
        }
        "circle" -> {
            val radius = readln().toDouble()
            PI * radius.pow(2)
        }
        else ->
            0.0
    }
    println(area)
}