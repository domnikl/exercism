import kotlin.math.pow
import kotlin.math.sqrt

class Point(private val x: Float, private val y: Float) {
    fun distance(other: Point): Float {
        val a = (this.x - other.x).pow(2)
        val b = (this.y - other.y).pow(2)

        return sqrt(a + b)
    }
}

object Darts {
    private const val OUTER_RADIUS = 10F
    private const val MIDDLE_RADIUS = 5F
    private const val INNER_RADIUS = 1F

    fun score(x: Number, y: Number): Int {
        val center = Point(0F, 0F)
        val distance = center.distance(Point(x.toFloat(), y.toFloat()))

        return when {
            distance <= INNER_RADIUS -> 10
            distance <= MIDDLE_RADIUS -> 5
            distance <= OUTER_RADIUS -> 1
            else -> 0
        }
    }
}
