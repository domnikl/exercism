class Squares(private val foo: Int) {
    fun squareOfSum() = (1..foo).sum().let { it * it }

    fun sumOfSquares()= (1..foo).map { it * it }.sum()

    fun difference() = squareOfSum() - sumOfSquares()
}
