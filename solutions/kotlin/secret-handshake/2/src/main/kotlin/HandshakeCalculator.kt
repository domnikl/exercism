object HandshakeCalculator {
    private fun Int.has(signalIndex: Int) = (this shr signalIndex) and 0x1 == 1

    fun calculateHandshake(i: Int): List<Signal> {
        val signals = Signal.values().mapIndexedNotNull { index, signal ->
            if (i.has(index)) signal else null
        }

        return if (i.has(Signal.values().size)) signals.reversed() else signals
    }
}
