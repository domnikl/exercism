enum class Relationship {
    EQUAL, SUBLIST, SUPERLIST, UNEQUAL
}

fun List<Any>.relationshipTo(other: List<Any>): Relationship {
    return when {
        other == this -> Relationship.EQUAL
        this.isSubList(other) -> Relationship.SUBLIST
        other.isSubList(this) -> Relationship.SUPERLIST
        else -> Relationship.UNEQUAL
    }
}

private fun <E> List<E>.isSubList(other: List<E>): Boolean =
    this.isEmpty() || other.windowed(this.size).any { it == this }
