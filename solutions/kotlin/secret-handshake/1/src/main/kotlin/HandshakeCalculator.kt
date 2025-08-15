object HandshakeCalculator {
    fun calculateHandshake(i: Int): List<Signal> {
        return Signal.values().mapNotNull { signal ->
            val v = if (signal.ordinal == 0) 1 else (signal.ordinal + 1) * 2

            when {
                v == 1 && (i and v == 1) -> signal
                v != 1 && i and v == v -> signal
                else -> null
            }
        }
    }
}
