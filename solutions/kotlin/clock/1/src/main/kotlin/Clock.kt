class Clock(private val hours: Int, private val minutes: Int) {
    private val m = convertToMinutes(hours, minutes)

    //TODO: find a convenient way to take over `toString()` and `equals()`

    override fun toString(): String {
        val minutes = m % 60
        val hours = m / 60 % 24

        /*var h = if (hours < 0) 24 + hours % 24 else hours
        var m = if (minutes < 0) 60 + minutes % 24 else minutes

        m %= 60
        h = (h + minutes / 60) % 24*/

        return "${hours.toString().padStart(2, '0')}:${minutes.toString().padStart(2, '0')}"
    }

    fun subtract(minutes: Int) {
        TODO("Implement the function to complete the task")
    }

    fun add(minutes: Int) {
        TODO("Implement the function to complete the task")
    }

    private fun convertToMinutes(hours: Int, minutes: Int): Int {
        val h = if (hours < 0) {
            24 + hours % 24
        } else {
            hours
        }

        val m = if (minutes < 0) {
            60 + minutes % 60
        } else {
            minutes
        }

        return (h % 24) * 60 + m
    }
}
