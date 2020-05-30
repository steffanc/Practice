package leet_code.problems

/**
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
 *
 * Example 1:
 * Input:
 * [
 * [ 1, 2, 3 ],
 * [ 4, 5, 6 ],
 * [ 7, 8, 9 ]
 * ]
 * Output: [1,2,3,6,9,8,7,4,5]
 *
 * Example 2:
 * Input:
 * [
 * [1, 2, 3, 4],
 * [5, 6, 7, 8],
 * [9,10,11,12]
 * ]
 * Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 */
enum class State { TOP, RIGHT, BOTTOM, LEFT }

fun spiralOrder(matrix: Array<IntArray>): List<Int> {
    if (matrix.isEmpty() || matrix[0].isEmpty()) return emptyList()
    var count = 0
    val n = matrix.size * matrix[0].size
    var state = State.TOP
    var top = Pair(0, 0)
    var right = Pair(0, matrix[0].size)
    var bottom = Pair(matrix.size, matrix[0].size - 1)
    var left = Pair(matrix.size - 1, -1)
    val out = mutableListOf<Int>()
    while (count < n) {
        when (state) {
            State.TOP -> {
                for (i in top.second until right.second) {
                    out.add(matrix[top.first][i])
                    count++
                }
                right = Pair(right.first + 1, right.second - 1)
                state = State.RIGHT
            }
            State.RIGHT -> {
                for (i in right.first until bottom.first) {
                    out.add(matrix[i][right.second])
                    count++
                }
                bottom = Pair(bottom.first - 1, bottom.second - 1)
                state = State.BOTTOM
            }
            State.BOTTOM -> {
                for (i in bottom.second downTo left.second + 1) {
                    out.add(matrix[bottom.first][i])
                    count++
                }
                left = Pair(left.first - 1, left.second + 1)
                state = State.LEFT
            }
            State.LEFT -> {
                for (i in left.first downTo top.first + 1) {
                    out.add(matrix[i][left.second])
                    count++
                }
                top = Pair(top.first + 1, top.second + 1)
                state = State.TOP
            }
        }
    }
    return out
}

fun main() {
    println(
        spiralOrder(
            arrayOf(
                arrayOf(1).toIntArray(),
                arrayOf(2).toIntArray(),
                arrayOf(3).toIntArray()
            )
        )
    )
}