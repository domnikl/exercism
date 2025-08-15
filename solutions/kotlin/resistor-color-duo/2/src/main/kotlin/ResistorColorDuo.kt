object ResistorColorDuo {
    private val map = mapOf(
            Color.BLACK to 0,
            Color.BROWN to 1,
            Color.RED to 2,
            Color.ORANGE to 3,
            Color.YELLOW to 4,
            Color.GREEN to 5,
            Color.BLUE to 6,
            Color.VIOLET to 7,
            Color.GREY to 8,
            Color.WHITE to 9
    )

    fun value(vararg colors: Color): Int {
        val ring1 = map[colors[0]]
        val ring2 = map[colors[1]]

        if (ring1 != null && ring2 != null) {
            return ring1 * 10 + ring2
        }

        throw IllegalArgumentException("Unknown color given")
    }
}
