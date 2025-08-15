object BeerSong {
    fun verses(startAt: Int, endInclusive: Int): String {
        return startAt.downTo(endInclusive).joinToString("\n") { verse(it) }
    }

    private fun verse(i: Int): String {
        val secondLine = if (i == 0) {
            "Go to the store and buy some more, 99 bottles of beer on the wall."
        } else {
            "Take ${bottles(i).second} down and pass it around, ${bottles(i - 1).first.toLowerCase()} of beer on the wall."
        }

        return """
            ${bottles(i).first} of beer on the wall, ${bottles(i).first.toLowerCase()} of beer.
            $secondLine
            
        """.trimIndent()
    }

    private fun bottles(i: Int) = when {
        i == 0 -> Pair("No more bottles", "")
        i > 1 -> Pair("$i bottles", "one")
        else -> Pair("1 bottle", "it")
    }
}
