object Sieve {

    fun primesUpTo(upperBound: Int): List<Int> {
        val range = (2..upperBound)

        val noPrimes = range.flatMap { i ->
            range.map { x ->
                i * x
            }
        }

        return range - noPrimes
    }
}
