class Scale(private val tonic: String) {
    private val chromaticWithSharps = listOf("C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#", "B")
    private val chromaticWithFlats = listOf("F", "Gb", "G", "Ab", "A", "Bb", "B", "C", "Db", "D", "Eb", "E")

    fun chromatic(): List<String>
    {
        return when (tonic.capitalize()) {
            in listOf("C", "G", "F#", "A") -> chromaticWithSharps
            else -> chromaticWithFlats
        }
    }

    fun interval(intervals: String): List<String> {
        val chromatic = chromatic() + chromatic()

        return intervals
                .map(::mapIntervals)
                .accumulate(chromatic.indexOf(tonic.capitalize()))
                .map { chromatic[it] }
    }

    private fun mapIntervals(interval: Char): Int {
        return when (interval) {
            'M' -> 2
            'm' -> 1
            else -> 3
        }
    }
}

private fun List<Int>.accumulate(start: Int): List<Int> {
    var previous = start

    return this.map { i ->
        previous.also { previous += i }
    }
}
