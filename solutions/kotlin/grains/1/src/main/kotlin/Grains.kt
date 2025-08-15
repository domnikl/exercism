import java.math.BigInteger

object Board {

    fun getGrainCountForSquare(number: Int): BigInteger {
        return when (number) {
            1 -> BigInteger.ONE
            in 2..64 -> getGrainCountForSquare(number - 1) * BigInteger.TWO
            else -> throw IllegalArgumentException("Invalid square number given")
        }
    }

    fun getTotalGrainCount(): BigInteger {
        var x = BigInteger.ZERO

        for (i in 1..64) {
            x += getGrainCountForSquare(i)
        }

        return x
    }
}
