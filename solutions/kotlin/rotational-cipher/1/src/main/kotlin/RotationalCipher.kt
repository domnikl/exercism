class RotationalCipher(private val rotations: Int) {
    fun encode(text: String): String {
        return text.map(::rotate).joinToString("")
    }

    private fun rotate(c: Char): Char {
        if (!c.isLetter()) return c

        val max = if (c.isUpperCase()) 'Z' else 'z'
        val rotated = c + rotations

        return if (rotated > max) rotated - 26 else rotated
    }
}
