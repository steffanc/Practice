package leet_code.onsite_interview.google.two

import leet_code.TreeNode
import java.util.*

/**
 * Given the root of a binary tree, the level of its root is 1, the level of its children is 2, and so on.
 * Return the smallest level X such that the sum of all the values of nodes at level X is maximal.
 *
 *
 * Example 1:
 * Input: [1,7,0,7,-8,null,null]
 * Output: 2
 * Explanation:
 * Level 1 sum = 1.
 * Level 2 sum = 7 + 0 = 7.
 * Level 3 sum = 7 + -8 = -1.
 * So we return the level with the maximum sum which is level 2.
 *
 *
 * Note:
 * The number of nodes in the given tree is between 1 and 10^4.
 * -10^5 <= node.val <= 10^5
 *
 * O(n), O(n)
 */
fun maxLevelSum(root: TreeNode?): Int {
    if (root == null) return 0
    var max = Pair(Int.MIN_VALUE, Int.MIN_VALUE)
    val nodeQueue = mutableListOf<Pair<TreeNode, Int>>()
    nodeQueue.add(root to 1)
    var level = 1
    while (nodeQueue.isNotEmpty()) {
        var sum = 0
        while (true) {
            if (nodeQueue.isNotEmpty() && nodeQueue.first().second == level) {
                val node = nodeQueue.removeAt(0).first
                node.left?.let { nodeQueue.add(it to level + 1) }
                node.right?.let { nodeQueue.add(it to level + 1) }
                sum += node.`val`
            } else {
                break
            }
        }
        max = if (max.first > sum) max else sum to level
        level++
    }
    return max.second
}

fun main() {
    println(maxLevelSum(TreeNode(1).also {
        it.left = TreeNode(7).also {
            it.left = TreeNode(7); it.right = TreeNode(-8)
        }
        it.right = TreeNode(0)
    }))
}