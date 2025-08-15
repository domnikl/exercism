class ChangeCalculator(coins: List<Int>) {
    private val coins = coins.sortedDescending()

    fun computeMostEfficientChange(grandTotal: Int): List<Int> {
        require(grandTotal >= 0) { "Negative totals are not allowed." }

        if (grandTotal in coins) {
            return listOf(grandTotal)
        }

        val totals = mutableMapOf(0 to emptyList<Int>())

        coins.sortedDescending().forEach { coin ->
            (0..(grandTotal - coin)).forEach { i ->
                totals[i]?.let { previous ->
                    totals.computeIfAbsent(i + coin) { previous + coin }
                }
            }
        }

        return requireNotNull(totals[grandTotal]) { "The total $grandTotal cannot be represented in the given currency." }
    }
}
