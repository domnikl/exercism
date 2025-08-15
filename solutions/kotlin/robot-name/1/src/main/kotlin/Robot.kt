import java.util.Random

class Robot {
    var name = RobotNameRepository.generate()
        private set

    fun reset() {
        name = RobotNameRepository.generate()
    }
}

object RobotNameRepository {
    private val names = mutableSetOf<String>()

    fun generate(): String {
        return generateSequence { generateName() }.first { names.add(it) }
    }

    private fun generateName(): String {
        val chars = ('A'..'Z').toList()
        val first = chars.shuffled().first()
        val second = chars.shuffled().first()
        val number = Random().nextInt(999).toString()

        return "$first$second${number.padStart(3, '0')}"
    }
}
