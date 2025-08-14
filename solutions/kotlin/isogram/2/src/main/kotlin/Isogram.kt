object Isogram {
    fun isIsogram(input: String): Boolean {
        val allChars = input.toLowerCase().filter { it in 'a'..'z' }

        return allChars.length == allChars.toSet().size
    }
}
