object Prime {
    private var i = 0
    private val s2 = CachingSequence<Int> {
        generateSequence { i++ }.filter { n -> n > 1 && ((2 until n).none { i -> n % i == 0 }) }
    }

    fun nth(n: Int): Int {
        require(n > 0) { "There is no zeroth prime." }

        return s2.nth(n)
    }
}

class CachingSequence<T>(private val sequence: SequenceScope<T>.() -> Sequence<T>) {
    private val fetched = mutableListOf<T>()
    private val x = sequence<T> {
        sequence().forEach { yield(it) }
    }

    fun nth(n: Int): T {
        if (n >= fetched.size) {
            fetched.addAll(this.x.take(n - fetched.size))
        }

        return fetched[n - 1]
    }
}
