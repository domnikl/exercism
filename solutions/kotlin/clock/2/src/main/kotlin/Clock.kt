import kotlin.math.abs

class Clock(private var hours: Int, private var minutes: Int) {
    init {
        normalize()
    }

    override fun equals(other: Any?) = when(other) {
        is Clock -> hours == other.hours && minutes == other.minutes
        else -> false
    }

    override fun toString(): String {
        return "%02d:%02d".format(hours, minutes)
    }

    fun subtract(minutes: Int) {
        this.minutes -= minutes
        normalize()
    }

    fun add(minutes: Int) {
        this.minutes += minutes
        normalize()
    }

    private fun normalize() {
        if (abs(minutes) >= 60) {
            hours += minutes / 60
            minutes %= 60
        }

        if (minutes < 0) {
            hours -= 1
            minutes += 60
        }

        if (abs(hours) >= 24) {
            hours %= 24
        }

        if (hours < 0) {
            hours += 24
        }
    }
}
