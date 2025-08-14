object Isogram {
    fun isIsogram(input: String): Boolean {
        val sanitized = input.toLowerCase().replace("[^a-z]".toRegex(), "")

        return sanitized.toCharArray().toSet().size == sanitized.length
    }
}
