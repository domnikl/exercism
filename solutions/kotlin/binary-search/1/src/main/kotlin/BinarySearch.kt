import kotlin.math.ceil

object BinarySearch {
    fun search(list: List<Int>, item: Int): Int {
        var left = 0
        var right = list.size - 1

        while (left <= right) {
            val middle = ceil(left + right + 0F).toInt()

            when {
                item > list[middle] -> left = middle + 1
                item < list[middle] -> right = middle - 1
                else -> return middle
            }
        }

        throw NoSuchElementException()
    }
}
