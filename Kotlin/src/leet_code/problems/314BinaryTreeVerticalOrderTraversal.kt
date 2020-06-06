package leet_code.problems

import leet_code.TreeNode

/**
 * Given a binary tree, return the vertical order traversal of its nodes' values. (ie, from top to bottom, column by column).
 *
 * If two nodes are in the same row and column, the order should be from left to right.
 *
 * Examples 1:
 *
 * Input: [3,9,20,null,null,15,7]
 *
 *       3
 *      /\
 *     /  \
 *    9  20
 *       /\
 *      /  \
 *     15   7
 *
 * Output:
 *
 * [
 * [9],
 * [3,15],
 * [20],
 * [7]
 * ]
 * Examples 2:
 *
 * Input: [3,9,8,4,0,1,7]
 *
 *       3
 *      /\
 *     /  \
 *    9   8
 *   /\  /\
 *  /  \/  \
 * 4  01   7
 *
 * Output:
 *
 * [
 * [4],
 * [9],
 * [3,0,1],
 * [8],
 * [7]
 * ]
 * Examples 3:
 *
 * Input: [3,9,8,4,0,1,7,null,null,null,2,5] (0's right child is 2 and 1's left child is 5)
 *
 *          3
 *         /\
 *        /  \
 *       9   8
 *      /\  /\
 *     /  \/  \
 *    4  01   7
 *       /\
 *      /  \
 *     5   2
 *
 * Output:
 *
 * [
 * [4],
 * [9,5],
 * [3,0,1],
 * [8,2],
 * [7]
 * ]
 *
 * O(n), O(n)
 */
fun verticalOrder(root: TreeNode?): List<List<Int>> {
    val out = mutableListOf<MutableList<Int>>()
    if (root == null) return out
    val queue = mutableListOf<Pair<TreeNode, Int>>()
    queue.add(root to 0)
    var centerOffset = 0
    while (queue.isNotEmpty()) {
        val pair = queue.removeAt(0)
        if (centerOffset + pair.second >= out.size) {
            out.add(mutableListOf(pair.first.`val`))
        } else if (centerOffset + pair.second < 0) {
            out.add(0, mutableListOf(pair.first.`val`))
            centerOffset++
        } else {
            out[centerOffset + pair.second].add(pair.first.`val`)
        }
        pair.first.left?.let { queue.add(it to pair.second - 1) }
        pair.first.right?.let { queue.add(it to pair.second + 1) }
    }
    return out
}

fun main() {
}