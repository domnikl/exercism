object RunLengthEncoding {
    fun encode(input: String): String {
        var count = 1
        var result = ""

        (1 until input.length + 1).forEach { i ->
            if (input.getOrNull(i) != input[i - 1]) {
                if (count == 1) {
                    result += input[i - 1]
                } else {
                    result += count.toString() + input[i - 1]
                }

                count = 1
            } else {
                count++
            }
        }

        return result
    }

    fun decode(input: String): String {
        return Regex("[0-9]*[a-zA-Z ]").findAll(input).joinToString("") {
            val count = it.value.filter { x -> x.isDigit() }
            val char = it.value.filter { x -> !x.isDigit() }

            char.repeat(count.toIntOrNull() ?: 1)
        }
    }
}
