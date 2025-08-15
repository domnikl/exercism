class Deque<T> {
    private var first: Node<T>? = null
    private var last: Node<T>? = null

    // add to back
    fun push(value: T) {
        val newSecondLast = last
        val newLast = Node(value, null, newSecondLast)
        newSecondLast?.next = newLast

        last = newLast

        if (first == null) first = last
    }

    // remove from back
    fun pop(): T? {
        val value = last?.value
        val newLast = last?.previous
        newLast?.next = null

        last = newLast

        return value
    }

    // add to front
    fun unshift(value: T) {
        val newSecond = first
        val newFirst = Node(value, newSecond, null)
        newSecond?.previous = newFirst

        first = newFirst

        if (last == null) last = first
    }

    // remove from front
    fun shift(): T? {
        val value = first?.value
        val newFirst = first?.next
        newFirst?.previous = null

        first = newFirst

        return value
    }

    data class Node<T>(
        val value: T,
        var next: Node<T>?,
        var previous: Node<T>?
    )
}
