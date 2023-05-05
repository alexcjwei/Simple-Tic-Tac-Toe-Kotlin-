package tictactoe

import kotlin.math.abs

typealias Board = MutableList<MutableList<Char>>
data class Move(val x: Int, val y: Int)

fun constructBoard(input: String): Board {
    val charArray = input.toCharArray()

    return mutableListOf(
        mutableListOf(charArray[0], charArray[1], charArray[2]),
        mutableListOf(charArray[3], charArray[4], charArray[5]),
        mutableListOf(charArray[6], charArray[7], charArray[8]),
    )
}

fun printBoard(board: Board) {
    println(
        """
            ---------
            | ${board[0][0]} ${board[0][1]} ${board[0][2]} |
            | ${board[1][0]} ${board[1][1]} ${board[1][2]} |
            | ${board[2][0]} ${board[2][1]} ${board[2][2]} |
            ---------
        """.trimIndent()
    )
}

fun validateBoard(board: Board): Boolean {
    var xs = 0
    var os = 0
    for (row in board) {
        xs += row.count { it == 'X' }
        os += row.count { it == 'O' }
    }

    if (isBoardWinner(board, 'X') && isBoardWinner(board, 'O')) {
        return false
    } else if (abs(xs - os) >= 2) {
        return false
    }
    return true
}

fun isBoardWinner(board: Board, player: Char): Boolean {
    // If rows all equal
    for (row in board) {
        if (row.all { it == player }) {
            return true
        }
    }
    // If columns all equal
    for (j in board[0].indices) {
        var isAllPlayer = true
        for (i in board.indices) {
            if (board[i][j] != player) {
                isAllPlayer = false
            }
        }
        if (isAllPlayer) {
            return true
        }
    }

    var isMainDiagAllPlayer = true; var isReverseDiagAllPlayer = true
    for (i in board.indices) {
        // Check main diag
        if (board[i][i] != player) {
            isMainDiagAllPlayer = false
        }
        if (board[i][2-i] != player) {
            isReverseDiagAllPlayer = false
        }
    }
    if (isMainDiagAllPlayer || isReverseDiagAllPlayer) {
        return true
    }

    return false
}

fun isDraw(board: Board): Boolean {
    for (row in board) {
        if ('_' in row) {
            return false
        }
    }
    return true
}

fun printBoardState(board: Board) {
    if (!validateBoard(board)) {
        println("Impossible")
    } else if (isBoardWinner(board, 'X')) {
        println("X wins")
    } else if (isBoardWinner(board, 'O')) {
        println("O wins")
    } else if (isDraw(board)) {
        println("Draw")
    } else {
        println("Game not finished")
    }
}

fun getPlayerMove(board: Board): Move {
    val range = 1..board.size
    var x: Int? = null; var y: Int? = null

    while (x == null || y == null || x !in range || y !in range || board[x-1][y-1] != '_') {
        val (inX, inY) = readln().split(' ')
        x = inX.toIntOrNull()
        y = inY.toIntOrNull()

        if (x == null || y == null) {
            println("You should enter numbers!")
        } else if (x !in range || y !in range){
            println("Coordinates should be from 1 to 3!")
        } else if (board[x-1][y-1] != '_') {
            println("This cell is occupied! Choose another one!")
        }
    }
    return Move(x, y)
}

fun main() {
    val board = constructBoard("_________")
    // Keep printing the board and getting user input while the game is not over
    var turn = 1
    do {
        printBoard(board)
        val (x, y) = getPlayerMove(board)
        board[x-1][y-1] = when {
            turn % 2 == 1 -> 'X'
            else -> 'O'
        }
        printBoard(board)
        turn++
    } while (!(isBoardWinner(board, 'X') || isBoardWinner(board, 'O') || isDraw(board)))
    // Print the final board
    printBoard(board)
    printBoardState(board)
}