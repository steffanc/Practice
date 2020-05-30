package leet_code.phone_interview.google.two

import kotlin.math.min

/**
 * In a row of dominoes, A[i] and B[i] represent the top and bottom halves of the i-th domino.
 * (A domino is a tile with two numbers from 1 to 6 - one on each half of the tile.)
 *
 * We may rotate the i-th domino, so that A[i] and B[i] swap values.
 *
 * Return the minimum number of rotations so that all the values in A are the same, or all the values in B are the same.
 *
 * If it cannot be done, return -1.
 *
 *
 * Example 1:
 * Input: A = [2,1,2,4,2,2], B = [5,2,6,2,3,2]
 * Output: 2
 * Explanation:
 * The first figure represents the dominoes as given by A and B: before we do any rotations.
 * If we rotate the second and fourth dominoes, we can make every value in the top row equal to 2, as indicated by the second figure.
 *
 *
 * Example 2:
 * Input: A = [3,5,1,2,3], B = [3,6,3,3,4]
 * Output: -1
 * Explanation:
 * In this case, it is not possible to rotate the dominoes to make one row of values equal.
 *
 *
 * Note:
 * 1 <= A[i], B[i] <= 6
 * 2 <= A.length == B.length <= 20000
 */

fun minDominoRotations(A: IntArray, B: IntArray): Int {
    if (A.size != B.size) return -1
    if (A.isEmpty() || B.isEmpty()) return -1
    if (A.size == 1) return 0
    var topValid = true
    var bottomValid = true
    val top = A[0]
    val bottom = B[0]
    var topTop = 1
    var topBottom = 0
    var bottomTop = 0
    var bottomBottom = 1
    for (i in 1 until A.size) {
        if (topValid) {
            if (A[i] == top) {
                topTop++
            }
            if (B[i] == top) {
                topBottom++
            }
            if (A[i] != top && B[i] != top) {
                topValid = false
            }
        }

        if (bottomValid) {
            if (A[i] == bottom) {
                bottomTop++
            }
            if (B[i] == bottom) {
                bottomBottom++
            }
            if (A[i] != bottom && B[i] != bottom) {
                bottomValid = false
            }
        }
    }

    return if (topValid && bottomValid) {
        min(min(A.size - topTop, A.size - topBottom), min(A.size - bottomTop, A.size - bottomBottom))
    } else if (topValid) {
        min(A.size - topTop, A.size - topBottom)
    } else if (bottomValid) {
        min(A.size - bottomTop, A.size - bottomBottom)
    } else {
        -1
    }
}

fun main() {
    println(
        minDominoRotations(
            arrayOf(1, 2, 1, 1, 1, 2, 2, 2).toIntArray(),
            arrayOf(2, 1, 2, 2, 2, 2, 2, 2).toIntArray()
        )
    )
}
