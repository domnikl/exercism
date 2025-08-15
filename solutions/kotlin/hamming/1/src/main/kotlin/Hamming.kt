object Hamming {
    fun compute(s: String, s1: String): Int {
        if (s.length != s1.length) {
            throw IllegalArgumentException("left and right strands must be of equal length.")
        }

        return s.mapIndexedNotNull { i, x ->
            if (x != s1[i]) x else null
        }.count()
    }
}
