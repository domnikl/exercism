object Transpose {
    fun transpose(input: List<String>): List<String> {
        val out = (0 until input.longest()).map { colIndex ->
            input.indices.map { rowIndex ->
                input[rowIndex].getOrNull(colIndex) ?: when {
                    input.drop(rowIndex).longest() > colIndex -> " "
                    else -> ""
                }
            }
        }

        return out.map { it.joinToString("") }
    }
}

private fun List<String>.longest(): Int = map { it.length }.max() ?: 0
