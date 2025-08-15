class Anagram(private val source: String) {
    private val of = source.toLowerCase().toSortedCharList()

    fun match(anagrams: Collection<String>): Set<String> {
        return anagrams
            .filter { it.toLowerCase().toSortedCharList() == of }
            .filterNot { it.equals(source, ignoreCase = true) }
            .toSet()
    }
}

private fun String.toSortedCharList(): List<Char> {
    return this.toCharArray().sorted()
}
