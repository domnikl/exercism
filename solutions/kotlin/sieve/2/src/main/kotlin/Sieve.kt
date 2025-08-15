object Sieve {
    fun primesUpTo(upperBound: Int): List<Int> {
        val multiples = 2..(upperBound / 2)
        val sieve = Array(init = { true }, size = upperBound + 1)

        sieve.forEachIndexed { index, _ ->
            when {
                index in listOf(0, 1) -> sieve[index] = false
                sieve[index] -> multiples.forEach { x ->
                    if (index * x <= sieve.size - 1) {
                        sieve[index * x] = false
                    }
                }
            }
        }

        return sieve
            .withIndex()
            .filter { it.value }
            .map { it.index }
    }
}
