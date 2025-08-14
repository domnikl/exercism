class ChangeCalculator(private val coins: List<Int>) {

    fun computeMostEfficientChange(grandTotal: Int): List<Int> {
        if (grandTotal in coins) {
            return listOf(grandTotal)
        }

        return change(grandTotal, coins)!!

/*        val changes = coins.map { change(grandTotal, it) }

        return changes.filterNotNull().minBy { it.size }!!*/
    }

    private fun coins(grandTotal: Int): List<List<Int>> {
        return coins
                .filter { it <= grandTotal }
                .mapIndexed { index, _ -> coins.subList(0, index + 1) }
    }

    private fun change(total: Int, coins: List<Int>): List<Int>? {
        val change = mutableListOf<Int>()
        val useCoins = coins.filter { it <= total }
        var remainingTotal = total

        useCoins.sortedDescending().forEach { coin ->
            while (remainingTotal > 0 && remainingTotal >= coin && canChangeRest(remainingTotal, coin, coins)) {
                change.add(coin)
                remainingTotal -= coin
            }
        }

        if (remainingTotal > 0) {
            return null
        }

        return change
    }

    private fun canChangeRest(total: Int, coin: Int, coins: List<Int>): Boolean {
        if (total - coin < 0) {
            return false
        }

        return change(total - coin, coins) == null
    }
}
