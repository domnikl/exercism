object Acronym {
    fun generate(phrase: String): String {
        return phrase
                .split(' ', '-')
                .filterNot(String::isEmpty)
                .map { it.first().toUpperCase() }
                .joinToString("")
    }
}
