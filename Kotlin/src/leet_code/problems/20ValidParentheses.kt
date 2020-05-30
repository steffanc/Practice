package leet_code.problems

/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *
 * An input string is valid if:
 *
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Note that an empty string is also considered valid.
 *
 * Example 1:
 * Input: "()"
 * Output: true
 *
 * Example 2:
 * Input: "()[]{}"
 * Output: true
 *
 * Example 3:
 * Input: "(]"
 * Output: false
 *
 * Example 4:
 * Input: "([)]"
 * Output: false
 *
 * Example 5:
 * Input: "{[]}"
 * Output: true
 *
 * O(n), O(n)
 */
fun isValid(s: String): Boolean {
    val stack = mutableListOf<Char>()
    s.forEach {
        when (it) {
            '(', '[', '{' -> stack.add(0, it)
            ')' -> {
                try {
                    if (stack.first() != '(') return false
                } catch (e: NoSuchElementException) {
                    return false
                }
                stack.removeAt(0)
            }
            ']' -> {
                try {
                    if (stack.first() != '[') return false
                } catch (e: NoSuchElementException) {
                    return false
                }
                stack.removeAt(0)
            }
            '}' -> {
                try {
                    if (stack.first() != '{') return false
                } catch (e: NoSuchElementException) {
                    return false
                }
                stack.removeAt(0)
            }
        }
    }
    return stack.isEmpty()
}

fun main() {
    println(isValid("[(])"))
}