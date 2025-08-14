object Pangram {
    fun isPangram(s: String): Boolean {
        return ('a'..'z').map { c -> s.toLowerCase().count { it == c }}.all { it >= 1 }
    }
}
