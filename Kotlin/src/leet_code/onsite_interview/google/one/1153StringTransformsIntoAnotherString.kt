package leet_code.onsite_interview.google.one


/**
 * Given two strings str1 and str2 of the same length, determine whether you can transform str1 into str2
 * by doing zero or more conversions.
 *
 * In one conversion you can convert all occurrences of one character in str1 to any other lowercase English character.
 *
 * Return true if and only if you can transform str1 into str2.
 *
 *
 * Example 1:
 *
 * Input: str1 = "aabcc", str2 = "ccdee"
 * Output: true
 * Explanation: Convert 'c' to 'e' then 'b' to 'd' then 'a' to 'c'. Note that the order of conversions matter.
 * Example 2:
 *
 * Input: str1 = "leetcode", str2 = "codeleet"
 * Output: false
 * Explanation: There is no way to transform str1 to str2.
 *
 *
 * Note:
 *
 * 1 <= str1.length == str2.length <= 10^4
 * Both str1 and str2 contain only lowercase English letters.
 */
fun canConvert(str1: String, str2: String): Boolean {
    if (str1.length != str2.length) return false
    if (str1.isEmpty()) return true
    val charMap = mutableMapOf<Char, Char>()
    var i = 0
    while (i < str1.length) {
        val c1 = str1[i]
        val c2 = str2[i]
        if (!charMap.containsKey(c1)) {
            charMap[c1] = c2
            charMap[c2] = c2
        } else if (charMap[c1] != c2) {
            return false
        }
        i++
    }
    return true
}

fun main() {
    println(
        canConvert(
            "aabcc",
            "ccdee"
//            "abcdefghijklmnopqrstuvwxyz",
//            "bcdefghijklmnopqrstuvwxyza"
        )
    )
}