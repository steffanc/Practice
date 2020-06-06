package leet_code.problems

import java.util.*
import kotlin.contracts.contract

/**
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
 *
 * Integers in each row are sorted in ascending from left to right.
 * Integers in each column are sorted in ascending from top to bottom.
 *
 * Example:
 * Consider the following matrix:
 * [
 * [1,   4,  7, 11, 15],
 * [2,   5,  8, 12, 19],
 * [3,   6,  9, 16, 20],
 * [10, 13, 14, 17, 24],
 * [18, 21, 23, 26, 30]
 * ]
 * Given target = 5, return true.
 * Given target = 20, return false.
 *
 * O(m*log(n)), O(1)
 */
fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
    if (matrix.isEmpty() || matrix[0].isEmpty()) return false
    matrix.forEach { row ->
        if (row[0] > target || row[row.size - 1] < target) return@forEach
        if (binarySearch(row, target)) return true
    }
    return false
}

fun binarySearch(arr: IntArray, target: Int): Boolean {
    var low = 0
    var high = arr.size - 1
    var middle: Int
    while (low <= high) {
        middle = low + (high - low) / 2
        val num = arr[middle]
        when {
            target == num -> return true
            target > num -> low = middle + 1
            else -> high = middle - 1
        }
    }
    return false
}

/**
 * O (n + m), O(1)
 */
fun searchMatrix2(matrix: Array<IntArray>, target: Int): Boolean {
    if (matrix.isEmpty() || matrix[0].isEmpty()) return false
    var row = matrix.size - 1
    var col = 0
    while (true) {
        if (row < 0 || col > matrix[0].size - 1) return false
        if (matrix[row][col] == target) return true
        if (matrix[row][col] > target) row--
        else col++
    }
}

fun main() {
    println(
        searchMatrix2(
            arrayOf(
                arrayOf(1, 4, 7, 11, 15).toIntArray(),
                arrayOf(2, 5, 8, 12, 19).toIntArray(),
                arrayOf(3, 6, 9, 16, 20).toIntArray(),
                arrayOf(10, 13, 14, 17, 24).toIntArray(),
                arrayOf(18, 21, 23, 26, 30).toIntArray()
            ),
            5
        )
    )
}


