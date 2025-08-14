object WordCount {
    fun phrase(s: String): Map<String, Int> = s.split(Regex("[^a-zA-Z0-9']"))
        .filterNot { it.isEmpty() }
        .map { it.toLowerCase().trim('\'') }
        .fold(mutableMapOf()) {
            acc, word -> acc[word] = acc[word]?.plus(1) ?: 1; acc
        }
}
