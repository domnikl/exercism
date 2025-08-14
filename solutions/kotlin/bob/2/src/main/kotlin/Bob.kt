object Bob {
    fun hey(input: String) = when {
        input.isBlank() -> "Fine. Be that way!"
        input.yelling() && input.question() -> "Calm down, I know what I'm doing!"
        input.yelling() -> "Whoa, chill out!"
        input.question() -> "Sure."
        else -> "Whatever."
    }
}

private fun String.question() = trim().endsWith('?')

private fun String.yelling() = this == toUpperCase() && this.any { it.isLetter() }
