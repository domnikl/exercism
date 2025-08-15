object RunLengthEncoding {
    fun encode(input: String): String {
        if (input.isEmpty()) return ""

        val letter = input.first()
        val count = input.takeWhile { it == letter }.count()

        return when {
            count > 1 -> "$count"
            else -> ""
        } + letter + encode(input.substring(count))
    }

    fun decode(input: String): String {
        if (input.isEmpty()) return ""

        val digits = input.takeWhile { it.isDigit() }
        val tail = input.substring(digits.count())
        val repeatedChar = tail.first().toString().repeat(digits.toIntOrNull() ?: 1)

        return repeatedChar + decode(tail.substring(1))
    }
}
