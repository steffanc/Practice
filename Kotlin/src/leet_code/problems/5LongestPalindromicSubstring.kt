package leet_code.problems

/**
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 *
 * Example 1:
 *
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 * Example 2:
 *
 * Input: "cbbd"
 * Output: "bb"
 */
fun longestPalindrome(s: String): String {
    var l = s.length
    var start = 0
    var end = l - 1
    while (true) {
        s.slice(start..end).let {
            when {
                isPalindrome(it) -> {
                    return it
                }
                end == s.length - 1 -> {
                    l--
                    start = 0
                    end = l - 1
                }
                else -> {
                    start++
                    end++
                }
            }
        }
    }
}

fun isPalindrome(s: String): Boolean {
    return s == s.reversed()
}

fun main(args: Array<String>) {
    println(longestPalindrome("bbacabb"))
}
