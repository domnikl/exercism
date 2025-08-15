import kotlin.math.pow

object ResistorColorTrio {
    fun text(vararg input: Color): String {
        val value = input.map { it.ordinal }.let {
            (it[0] * 10 + it[1]) * 10F.pow(it[2])
        }

        for (unit in Unit.values().reversed()) {
            if (value >= 1000F.pow(unit.ordinal) && value % 1000F.pow(unit.ordinal) == 0F) {
                val x = value / 1000F.pow(unit.ordinal)

                return "${x.toInt()} ${unit.name.toLowerCase()}"
            }
        }

        return "${value.toInt()} ${Unit.OHMS.name}"
    }
}
