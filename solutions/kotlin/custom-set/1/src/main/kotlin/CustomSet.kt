class CustomSet(vararg seeds: Int) {
    private val data = mutableListOf<Int>()

    init {
        seeds.forEach { add(it) }
    }

    fun isEmpty() = data.isEmpty()
    fun isSubset(other: CustomSet) = other.data.containsAll(data)
    fun isDisjoint(other: CustomSet) = !data.any { other.data.contains(it) }

    fun contains(other: Int) = data.contains(other)

    fun intersection(other: CustomSet): CustomSet {
        val intersect = data.intersect(other.data)

        return CustomSet(*intersect.toIntArray())
    }

    fun add(other: Int) = data.add(other)

    override fun equals(other: Any?): Boolean {
        return when (other) {
            is CustomSet -> data.containsAll(other.data) && other.data.containsAll(data)
            else -> false
        }
    }

    operator fun plus(other: CustomSet): CustomSet {
        return CustomSet(*(data.toIntArray() + other.data.toIntArray()))
    }

    operator fun minus(other: CustomSet): CustomSet {
        val newValues = data.filterNot { other.data.contains(it) }.toIntArray()

        return CustomSet(*newValues)
    }
}
