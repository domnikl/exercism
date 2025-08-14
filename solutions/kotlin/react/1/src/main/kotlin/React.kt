class Reactor<T> {
    abstract inner class Cell {
        abstract val value: T
        internal val dependents = mutableSetOf<ComputeCell>()
    }

    interface Subscription {
        fun cancel()
    }

    inner class Sub(private val cell: ComputeCell, private val callbackFunction: (T) -> Unit): Subscription {
        override fun cancel() {
            cell.removeCallback(this)
        }

        fun notify(value: T) {
            callbackFunction(value)
        }
    }


    inner class InputCell(initialValue: T): Cell() {
        override var value: T = initialValue
            set(value) {
                field = value
                dependents.forEach { it.propagate() }
                dependents.forEach { it.fireCallbacks() }
            }
    }

    inner class ComputeCell(private vararg val cells: Cell, val computeFunction: (params: List<T>) -> T): Cell() {
        private val activeCallbacks = mutableSetOf<Sub>()

        override var value = computeValue()
            private set

        private var lastCallbackValue = value

        init {
            cells.forEach {
                it.dependents.add(this)
            }
        }

        private fun computeValue(): T {
            return computeFunction(cells.map { it.value })
        }

        fun addCallback(callbackFunction: (T) -> Unit): Subscription {
            return Sub(this, callbackFunction).also {
                activeCallbacks.add(it)
            }
        }

        internal fun propagate() {
            val newValue = computeValue()

            if (newValue == value) return

            value = newValue
            dependents.forEach { it.propagate() }
        }

        internal fun fireCallbacks() {
            if (value == lastCallbackValue) return

            lastCallbackValue = value

            activeCallbacks.forEach { it.notify(value) }
            dependents.forEach { it.fireCallbacks() }
        }

        internal fun removeCallback(sub: Sub) {
            activeCallbacks.remove(sub)
        }
    }
}
