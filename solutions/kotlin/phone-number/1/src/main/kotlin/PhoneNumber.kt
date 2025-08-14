class PhoneNumber(private val input: String) {
    val number by lazy {
        val cleaned = input
                .replace("[^0-9]".toRegex(), "")
                .trimStart('1')

        val areaCodeValid = cleaned.first() !in listOf('0', '1')
        val exchangeCodeValid = cleaned.elementAt(3) !in listOf('0', '1')

        if (cleaned.length == 10 && areaCodeValid && exchangeCodeValid) {
            cleaned
        } else {
            null
        }
    }
}
