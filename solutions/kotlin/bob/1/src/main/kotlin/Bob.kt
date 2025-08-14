object Bob {
    fun hey(input: String) = when {
        input.isBlank() -> "Fine. Be that way!"
        input.yelling() && input.question() -> "Calm down, I know what I'm doing!"
        input.yelling() -> "Whoa, chill out!"
        input.question() -> "Sure."
        else -> "Whatever."
    }
}

private fun String.question() = if (this.isEmpty()) false else this.trim().last() == '?'

private fun String.yelling() = this == this.toUpperCase() && this.any { it.isLetter() }
