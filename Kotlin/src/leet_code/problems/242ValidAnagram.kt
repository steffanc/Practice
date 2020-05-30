package leet_code.problems

/**
 * Given two strings s and t , write a function to determine if t is an anagram of s.
 *
 * Example 1:
 * Input: s = "anagram", t = "nagaram"
 * Output: true
 *
 * Example 2:
 * Input: s = "rat", t = "car"
 * Output: false
 *
 * Note:
 * You may assume the string contains only lowercase alphabets.
 *
 * Follow up:
 * What if the inputs contain unicode characters? How would you adapt your solution to such case?
 *
 * O(n), O(n)
 */
fun isAnagram(s: String, t: String): Boolean {
    val charMap = mutableMapOf<Char, Int>()
    s.forEach { charMap[it] = charMap.getOrDefault(it, 0) + 1 }

    t.forEach {
        val count = charMap.getOrDefault(it, 0)
        if (count == 0) return false
        charMap[it] = count - 1
    }
    return charMap.values.sum() == 0
}

fun main() {
    println(isAnagram("anagram", "nagarm"))
}