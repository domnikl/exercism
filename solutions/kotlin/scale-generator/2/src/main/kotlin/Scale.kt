class Scale(private val tonic: String) {
    private val chromaticWithSharps = listOf("A", "A#", "B", "C", "C#", "D", "D#", "E", "F", "F#", "G", "G#")
    private val chromaticWithFlats = listOf("A", "Bb", "B", "C", "Db", "D", "Eb", "E", "F", "Gb", "G", "Ab")

    fun chromatic(): List<String>
    {
        val scale = when (tonic) {
            "F", "Bb", "Eb", "Ab", "Db", "Gb", "d", "g", "c", "f", "bb", "eb" -> chromaticWithFlats
            else -> chromaticWithSharps
        }

        val start = scale.indexOf(tonic.capitalize())

        return scale.drop(start) + scale.take(start)
    }

    fun interval(intervals: String): List<String> {
        val indexes = listOf(0) + intervals
                .map(::mapInterval)
                .reversed()
                .windowed(intervals.length, 1, true)
                .map { it.sum() }

        return chromatic().filterIndexed { i, _ -> i in indexes }
    }

    private fun mapInterval(interval: Char) = when (interval) {
        'A' -> 3
        'M' -> 2
        'm' -> 1
        else -> throw IllegalArgumentException("Unknown interval given")
    }
}
