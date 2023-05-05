fun main() {
    val n = readln().toInt()
    var longestSeqLen = 0; var curSeqLen = 0; var prev = Int.MIN_VALUE
    repeat(n) {
        val cur = readln().toInt()

        // Update current sequence
        if (cur >= prev) {
            curSeqLen++
        } else {
            curSeqLen = 1
        }

        if (curSeqLen > longestSeqLen) {
            longestSeqLen = curSeqLen
        }
        prev = cur
    }
    println(longestSeqLen)
}