class DiamondPrinter {
    fun printToList(max: Char): List<String>? {
        val elements = ('A'..max).toList()

        val head = elements.mapIndexed { index, c ->
            val outer = " ".repeat(elements.size - index - 1)

            if (c == 'A') {
                "$outer$c$outer"
            } else {
                val inner = " ".repeat((index - 1) * 2 + 1)

                "$outer$c$inner$c$outer"
            }
        }

        return head + head.reversed().drop(1)
    }
}
