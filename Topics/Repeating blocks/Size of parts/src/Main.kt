fun main() {
    // put your code here
    val numComponents = readln().toInt()
    var larger = 0; var smaller = 0
    repeat(numComponents) {
        val component = readln().toInt()
        if (component < 0) {
            smaller++
        } else if (component > 0) {
            larger++
        }
    }
    println("${numComponents - larger - smaller} $larger $smaller")
}