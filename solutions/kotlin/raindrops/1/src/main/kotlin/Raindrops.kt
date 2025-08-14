object Raindrops {
    fun convert(input: Int): String {
        return mapOf(3 to "Pling", 5 to "Plang", 7 to "Plong").mapNotNull { (factor, result) ->
            if (input % factor == 0) result else null
        }.let {
            if (it.isEmpty()) input.toString() else it.joinToString("")
        }
    }
}
