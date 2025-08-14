import kotlin.math.max

class DiamondPrinter {
    fun printToList(max: Char): List<String>? {
        val elements = ('A'..max).toList()

        val head = elements.mapIndexed { index, c ->
            val outer = " ".repeat(elements.size - index - 1)
            val inner = " ".repeat(max((index - 1) * 2 + 1, 0))

            if (c == 'A') {
                "$outer$c$outer"
            } else {
                "$outer$c$inner$c$outer"
            }
        }

        return head + head.reversed().drop(1)
    }
}
