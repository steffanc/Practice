package leet_code.problems

/**
 * Given a non-empty string s, you may delete at most one character. Judge whether you can make it a palindrome.
 *
 * Example 1:
 * Input: "aba"
 * Output: True
 *
 * Example 2:
 * Input: "abcba"
 * Output: True
 * Explanation: You could delete the character 'c'.
 *
 * Note:
 * The string will only contain lowercase characters a-z. The maximum length of the string is 50000.
 *
 * aab
 */
fun validPalindrome(s: String): Boolean {
    var i = 0
    var j = s.length - 1
    while (i <= j) {
        if (s[i] != s[j]) {
            return s.removeRange(i..i).let { it == it.reversed() }
                    || s.removeRange(j..j).let { it == it.reversed() }
        }
        i++
        j--
    }
    return true
}

fun main() {
    println(validPalindrome("aba"))
    println(validPalindrome("bddb"))
}