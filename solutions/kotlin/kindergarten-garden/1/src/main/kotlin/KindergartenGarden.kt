class KindergartenGarden(private val diagram: String) {
    fun getPlantsOfStudent(student: String): List<String> {
        val index = (student.first().toUpperCase() - 'A') * 2
        val second = diagram.indexOf('\n') + 1
        val indices = listOf(index, index + 1, second + index, second + index + 1)

        return diagram.elementsAt(indices).map {
            when (it) {
                'G' -> "grass"
                'C' -> "clover"
                'R' -> "radishes"
                else -> "violets"
            }
        }
    }
}

private fun String.elementsAt(indices: List<Int>) = indices.map { this[it] }
