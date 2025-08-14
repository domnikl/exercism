import java.math.BigInteger

object Board {
    fun getGrainCountForSquare(number: Int): BigInteger {
        return when (number) {
            1 -> BigInteger.ONE
            in 1..64 -> getGrainCountForSquare(number - 1) * BigInteger.TWO
            else -> throw IllegalArgumentException("Invalid square number given")
        }
    }

    fun getTotalGrainCount(): BigInteger {
        return (1..64).map { getGrainCountForSquare(it) }.reduce { acc, bigInteger -> acc + bigInteger }
    }
}
