class Triangle<out T : Number>(private val a: T, private val b: T, private val c: T) {
    init {
        require(a.toDouble() > 0)
        require(b.toDouble() > 0)
        require(c.toDouble() > 0)
        require(a.toDouble() + b.toDouble() > c.toDouble())
        require(a.toDouble() + c.toDouble() > b.toDouble())
        require(c.toDouble() + b.toDouble() > a.toDouble())
    }

    val isEquilateral: Boolean = (a == b && b == c)
    val isIsosceles: Boolean = (a == b || a == c || b == c)
    val isScalene: Boolean = (a != b && b != c && c != a)
}
