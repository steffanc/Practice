package leet_code.onsite_interview.google.one

import kotlin.math.max
import kotlin.math.min

/**
 * Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.
 *
 * Example:
 *
 * Input:
 * 1 0 1 0 0
 * 1 0 1 1 1
 * 1 1 1 1 1
 * 1 0 0 1 0
 *
 * Output: 4
 *
 * O(mn), O(mn)
 */
fun maximalSquare(matrix: Array<CharArray>): Int {
    val iMatrix = matrix.indices.map { matrix[0].indices.map { 0 }.toTypedArray() }.toTypedArray()
    var maxLen = 0
    matrix.forEachIndexed { i, chars ->
        chars.forEachIndexed { j, c ->
            if (c == '1') {
                val t = try {
                    min(min(iMatrix[i - 1][j - 1], iMatrix[i - 1][j]), iMatrix[i][j - 1]) + 1
                } catch (e: IndexOutOfBoundsException) {
                    1
                }
                iMatrix[i][j] = t
                maxLen = max(maxLen, t)
            }
        }
    }
    return maxLen * maxLen
}

fun main() {
    println(
        maximalSquare(
            arrayOf(
                arrayOf('1', '0', '1', '0', '0').toCharArray(),
                arrayOf('1', '0', '1', '1', '1').toCharArray(),
                arrayOf('1', '1', '1', '1', '1').toCharArray(),
                arrayOf('1', '0', '0', '1', '0').toCharArray()
            )
        )
    )
}