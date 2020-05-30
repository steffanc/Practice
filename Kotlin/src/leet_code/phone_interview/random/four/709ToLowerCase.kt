package leet_code.phone_interview.random.four

/**
 * Implement function ToLowerCase() that has a string parameter str, and returns the same string in lowercase.
 *
 * Example 1:
 * Input: "Hello"
 * Output: "hello"
 *
 * Example 2:
 * Input: "here"
 * Output: "here"
 *
 * Example 3:
 * Input: "LOVELY"
 * Output: "lovely"
 */
fun toLowerCase(str: String): String {
    fun isUpper(char: Char): Boolean = char.toInt().let { it >= 'A'.toInt() && it <= 'Z'.toInt() }
    fun toLower(char: Char): Char = (char.toInt() + 32).toChar()
    return str.map {
        if (isUpper(it)) {
            toLower(it)
        } else {
            it
        }
    }.joinToString("")
}

fun main() {
    println(toLowerCase("Z)aB"))
}