object Isogram {
    fun isIsogram(input: String): Boolean {
        input.toLowerCase().filter { it in 'a'..'z' }.fold(setOf<Char>()) { x, y ->
            if (y in x) return false
            x + setOf(y)
        }

        return true
    }
}
