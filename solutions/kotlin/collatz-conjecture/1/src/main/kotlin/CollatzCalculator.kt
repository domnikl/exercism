object CollatzCalculator {
    fun computeStepCount(n: Int): Int {
        require(n > 0) { "Only natural numbers are allowed" }

        return step(n, 0)
    }

    private fun step(n: Int, steps: Int): Int {
        return when {
            n == 1 -> steps
            n % 2 == 0 -> step(n / 2, steps + 1)
            else -> step(n * 3 + 1, steps + 1)
        }
    }
}
