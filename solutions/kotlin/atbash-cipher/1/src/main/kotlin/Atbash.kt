object Atbash {
    private val alphabet = ('a'..'z').toList()

    fun encode(input: String) = cipher(input)
        .chunked(5)
        .joinToString(" ") { it.joinToString("") }

    fun decode(input: String) = cipher(input).joinToString("")

    private fun cipher(input: String) = input.mapNotNull {
        when {
            it.isDigit() -> it
            it.isLetter() -> alphabet[26 - alphabet.indexOf(it.toLowerCase()) - 1]
            else -> null
        }
    }
}
