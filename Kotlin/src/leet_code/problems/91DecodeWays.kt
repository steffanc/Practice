package leet_code.problems

/**
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:
 *
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * Given a non-empty string containing only digits, determine the total number of ways to decode it.
 *
 * Example 1:
 * Input: "12"
 * Output: 2
 * Explanation: It could be decoded as "AB" (1 2) or "L" (12).
 *
 * Example 2:
 * Input: "226"
 * Output: 3
 * Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).
 */
fun numDecodings(s: String): Int {
    val countMap = mutableMapOf<Int, Int>()
    fun _numDecodings(s: String, i: Int): Int {
        if (i >= s.length) return 1
        if (s[i] == '0') return 0
        if (countMap.containsKey(i)) return countMap.getValue(i)

        var count = 0
        for (j in i until i + 2) {
            if (j >= s.length) continue
            val num = s.slice(i..j).toInt()
            if (num > 26) continue
            count += _numDecodings(s, j + 1)
        }
        countMap[i] = count
        return count
    }
    return _numDecodings(s, 0)
}

fun main() {
    println(numDecodings("226"))
    println(numDecodings("7541387519572282368613553811323167125532172369624572591562685959575371877973171856836975137559677665"))
}