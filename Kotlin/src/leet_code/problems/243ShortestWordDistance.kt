package leet_code.problems

import kotlin.math.abs
import kotlin.math.min

/**
 * Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.
 *
 * Example:
 * Assume that words = ["practice", "makes", "perfect", "coding", "makes"].
 *
 * Input: word1 = “coding”, word2 = “practice”
 * Output: 3
 * Input: word1 = "makes", word2 = "coding"
 * Output: 1
 * Note:
 * You may assume that word1 does not equal to word2, and word1 and word2 are both in the list.
 */
fun shortestDistance(words: Array<String>, word1: String, word2: String): Int {
    var i1 = -1
    var i2 = -1
    var dist = Int.MAX_VALUE
    words.forEachIndexed { i, s ->
        if (s == word1) i1 = i
        if (s == word2) i2 = i
        if (i1 >= 0 && i2 >= 0) dist = min(abs(i2 - i1), dist)
    }
    return dist
}