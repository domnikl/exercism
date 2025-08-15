object SumOfMultiples {
    fun sum(of: Set<Int>, i: Int): Int {
        return of.map { sequence(it).takeWhile { x -> x < i }.toList() }.flatten().toSet().sum()
    }

    private fun sequence(base: Int): Sequence<Int> {
        var i = 0
        return generateSequence { base * ++i }
    }
}
