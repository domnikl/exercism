object Flattener {
    fun flatten(input: List<*>): List<Any> = input.filterNotNull().flatMap {
        when (it) {
            is List<*> -> flatten(it)
            else -> listOf(it)
        }
    }
}
