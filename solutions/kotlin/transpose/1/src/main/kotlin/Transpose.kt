object Transpose {
    fun transpose(input: List<String>): List<String> {
        val size = input.map { it.length }.max() ?: return emptyList()
        val result = Array(size) { "" }

        input.forEachIndexed { _, s ->
            (0 until size).forEach { x ->
                result[x] = result[x] + s.elementAtOrElse(x) { ' ' }
            }
        }

        return result.toList()
    }
}
