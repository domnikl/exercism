import java.util.Stack

object MatchingBrackets {
    private val opening = listOf('[', '{', '(')
    private val closing = listOf(']', '}', ')')

    fun isValid(input: String): Boolean {
        val stack = Stack<Int>()

        input.forEach {
            if (it in opening) {
                stack.push(opening.indexOf(it))
            } else if (it in closing) {
                if (!stack.empty() && stack.pop() != closing.indexOf(it)) {
                    return false
                }
            }
        }

        return stack.empty()
    }
}
