class MinesweeperBoard(private val board: List<String>) {
    fun withNumbers(): List<String> {
        return board.mapIndexed { row, content ->
            content.mapIndexed { col, c ->
                if (c == ' ') {
                    val s = sum(row, col)

                    if (s == 0) {
                        " "
                    } else {
                        s.toString()
                    }
                } else {
                    "*"
                }
            }.joinToString("")
        }
    }

    private fun sum(row: Int, col: Int): Int {
        return neighbors(row, col).sumBy { (row, col) ->
            when {
                row == -1 || row >= board.size -> 0
                col == -1 || col >= board[row].length -> 0
                board[row][col] == '*' -> 1
                else -> 0
            }
        }
    }

    private fun neighbors(row: Int, col: Int): List<Pair<Int, Int>> {
        return (-1..1).map { row - 1 to col + it } +
                (-1..1).map { row + 1 to col + it } +
                listOf(row to col -1, row to col + 1)
    }
}
