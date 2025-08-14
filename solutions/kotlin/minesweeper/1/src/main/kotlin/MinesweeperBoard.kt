class MinesweeperBoard(private val rows: List<String>) {
    fun withNumbers(): List<String> {
        if (rows.count() == 0) {
            return emptyList()
        }

        val result = arrayOf(
                arrayOf(0, 0, 0),
                arrayOf(0, 0, 0),
                arrayOf(0, 0, 0)
        )

        rows.forEachIndexed { row, c ->
            c.forEachIndexed { col, content ->
                if (content == '*') {
                    neighbors(row, col).forEach { (r, c) ->


                        result[r][c] += 1
                    }
                }
            }
        }

        return result.map {
            it.joinToString("").replace("0", " ")
        }
    }

    private fun neighbors(x: Int, y: Int): Map<Int, Int> {
        val n = listOf(
            x - 1 to y - 1,
            x - 1 to y,
            x - 1 to y + 1,
            x to y - 1,
            x to y + 1,
            x + 1 to y - 1,
            x + 1 to y,
            x + 1 to y + 1
        )

        return n.filter { it.first in 0..2 && it.second in 0..2 }.toMap()
    }
}
