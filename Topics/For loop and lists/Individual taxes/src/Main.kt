fun main() {
    val n = readln().toInt()
    val incomes = MutableList<Int>(n) { readln().toInt() }
    val taxRates = MutableList<Int>(n) { readln().toInt() }
    var maxCompany = 0
    var maxTax = 0
    for (i in 1..n) {
        val tax = incomes[i - 1] * taxRates[i - 1]
        if (tax > maxTax) {
            maxTax = tax
            maxCompany = i
        }
    }
    println(maxCompany)
}