package leet_code.problems

/**
 * Given a 2D board and a word, find if the word exists in the grid.
 *
 * The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those
 * horizontally or vertically neighboring. The same letter cell may not be used more than once.
 *
 * Example:
 * board =
 * [
 * ['A','B','C','E'],
 * ['S','F','C','S'],
 * ['A','D','E','E']
 * ]
 *
 * Given word = "ABCCED", return true.
 * Given word = "SEE", return true.
 * Given word = "ABCB", return false.
 *
 *
 * Constraints:
 * board and word consists only of lowercase and uppercase English letters.
 * 1 <= board.length <= 200
 * 1 <= board[i].length <= 200
 * 1 <= word.length <= 10^3
 */
fun exist(board: Array<CharArray>, word: String): Boolean {
    for (row in board.indices) {
        for (col in board[0].indices) {
            if (board[row][col] == word[0]) {
                if (search(board, row to col, word, 0, mutableSetOf())) return true
            }
        }
    }
    return false
}

fun search(
    board: Array<CharArray>,
    pos: Pair<Int, Int>,
    word: String,
    i: Int,
    visited: MutableSet<Pair<Int, Int>>
): Boolean {
    if (board[pos.first][pos.second] != word[i]) return false
    if (i == word.length - 1) return true
    val row = pos.first
    val col = pos.second
    visited.add(row to col)
    if (row - 1 >= 0 && !visited.contains(row - 1 to col)) {
        if (search(board, row - 1 to col, word, i + 1, visited)) return true
    }
    if (row + 1 < board.size && !visited.contains(row + 1 to col)) {
        if (search(board, row + 1 to col, word, i + 1, visited)) return true
    }
    if (col - 1 >= 0 && !visited.contains(row to col - 1)) {
        if (search(board, row to col - 1, word, i + 1, visited)) return true
    }
    if (col + 1 < board[0].size && !visited.contains(row to col + 1)) {
        if (search(board, row to col + 1, word, i + 1, visited)) return true
    }
    visited.remove(row to col)
    return false
}

fun main() {
    println(
        exist(
            arrayOf(
                arrayOf('A', 'B', 'C', 'E').toCharArray(),
                arrayOf('S', 'F', 'E', 'S').toCharArray(),
                arrayOf('A', 'D', 'E', 'E').toCharArray()
            ),
            "ABCESEEEFS"
        )
    )
}