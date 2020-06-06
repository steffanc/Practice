package leet_code.problems

/**
 * In a given grid, each cell can have one of three values:
 *
 * the value 0 representing an empty cell;
 * the value 1 representing a fresh orange;
 * the value 2 representing a rotten orange.
 * Every minute, any fresh orange that is adjacent (4-directionally) to a rotten orange becomes rotten.
 *
 * Return the minimum number of minutes that must elapse until no cell has a fresh orange.
 * If this is impossible, return -1 instead.
 *
 * Example 1:
 * Input: [[2,1,1],[1,1,0],[0,1,1]]
 * Output: 4
 *
 * Example 2:
 * Input: [[2,1,1],[0,1,1],[1,0,1]]
 * Output: -1
 * Explanation:  The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens
 * 4-directionally.
 *
 * Example 3:
 * Input: [[0,2]]
 * Output: 0
 * Explanation:  Since there are already no fresh oranges at minute 0, the answer is just 0.
 *
 * O(n), O(n)
 */
fun orangesRotting(grid: Array<IntArray>): Int {
    val EMPTY = 0
    val FRESH = 1
    val ROTTEN = 2

    val queue = mutableListOf<Pair<Pair<Int, Int>, Int>>()
    var freshCount = 0
    var minutes = 0
    for (i in grid.indices) {
        for (j in grid[0].indices) {
            if (grid[i][j] == ROTTEN) queue.add(i to j to 0)
            if (grid[i][j] == FRESH) freshCount++
        }
    }

    while (queue.isNotEmpty()) {
        val entry = queue.removeAt(0)
        minutes = kotlin.math.max(minutes, entry.second)
        val row = entry.first.first
        val col = entry.first.second
        if (row - 1 >= 0 && grid[row - 1][col] == FRESH) {
            grid[row - 1][col] = ROTTEN
            queue.add(row - 1 to col to entry.second + 1)
            freshCount--
        }
        if (row + 1 < grid.size && grid[row + 1][col] == FRESH) {
            grid[row + 1][col] = ROTTEN
            queue.add(row + 1 to col to entry.second + 1)
            freshCount--
        }
        if (col - 1 >= 0 && grid[row][col - 1] == FRESH) {
            grid[row][col - 1] = ROTTEN
            queue.add(row to col - 1 to entry.second + 1)
            freshCount--
        }
        if (col + 1 < grid[0].size && grid[row][col + 1] == FRESH) {
            grid[row][col + 1] = ROTTEN
            queue.add(row to col + 1 to entry.second + 1)
            freshCount--
        }
    }
    if (freshCount > 0) return -1
    else return minutes
}

fun main() {
    println(orangesRotting(arrayOf(arrayOf(1, 2).toIntArray())))
}

