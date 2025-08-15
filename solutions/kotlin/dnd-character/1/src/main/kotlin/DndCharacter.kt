import kotlin.math.floor
import kotlin.random.Random

private fun rollDices(): Int {
    return Array(4) { Random.nextInt(1, 6) }
        .sortedDescending()
        .take(3)
        .sum()
}

class DndCharacter {
    val strength: Int = ability()
    val dexterity: Int = ability()
    val constitution: Int = ability()
    val intelligence: Int = ability()
    val wisdom: Int = ability()
    val charisma: Int = ability()
    val hitpoints: Int = 10 + modifier(constitution)

    companion object {
        fun ability() = rollDices()
        fun modifier(score: Int) = floor((score - 10) / 2.0).toInt()
    }
}
