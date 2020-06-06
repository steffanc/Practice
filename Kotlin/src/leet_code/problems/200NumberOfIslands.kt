package leet_code.problems

/**
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded
 * by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all
 * four edges of the grid are all surrounded by water.
 *
 * Example 1:
 *
 * Input:
 * 11110
 * 11010
 * 11000
 * 00000
 *
 * Output: 1
 *
 * Example 2:
 * Input:
 * 11000
 * 11000
 * 00100
 * 00011
 *
 * Output: 3
 *
 * O(m * n), O(m * n)
 */
fun numIslands(grid: Array<CharArray>): Int {
    if (grid.isEmpty() || grid[0].isEmpty()) return 0

    var num = 0
    val visited = mutableSetOf<Pair<Int, Int>>()
    for (i in grid.indices) {
        for (j in grid[0].indices) {
            if (grid[i][j] == '1' && !visited.contains(i to j)) {
                visitIsland(grid, visited, i to j)
                num++
            }
        }
    }
    return num
}

fun visitIsland(grid: Array<CharArray>, visited: MutableSet<Pair<Int, Int>>, coord: Pair<Int, Int>) {
    visited.add(coord)
    val row = coord.first
    val col = coord.second
    // top
    if (row - 1 >= 0 && grid[row - 1][col] == '1' && !visited.contains(row - 1 to col))
        visitIsland(grid, visited, row - 1 to col)

    // bottom
    if (row + 1 < grid.size && grid[row + 1][col] == '1' && !visited.contains(row + 1 to col))
        visitIsland(grid, visited, row + 1 to col)

    // left
    if (col - 1 >= 0 && grid[row][col - 1] == '1' && !visited.contains(row to col - 1))
        visitIsland(grid, visited, row to col - 1)

    // right
    if (col + 1 < grid[0].size && grid[row][col + 1] == '1' && !visited.contains(row to col + 1))
        visitIsland(grid, visited, row to col + 1)
}


fun main() {
    println(
        numIslands(
            arrayOf(
                charArrayOf('1', '1', '0', '0', '0'),
                charArrayOf('1', '1', '0', '0', '0'),
                charArrayOf('0', '0', '1', '0', '0'),
                charArrayOf('0', '0', '0', '1', '1')
            )
        )
    )
}