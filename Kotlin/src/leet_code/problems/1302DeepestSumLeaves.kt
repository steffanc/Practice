package leet_code.problems

import leet_code.TreeNode

/**
 * Given a binary tree, return the sum of values of its deepest leaves.
 *
 * Example 1:
 * Input: root = [1,2,3,4,5,null,6,7,null,null,null,null,8]
 * Output: 15
 */
fun deepestLeavesSum(root: TreeNode?): Int {
    var maxDepth = 0
    var sum = 0
    fun dfs(n: TreeNode?, depth: Int) {
        if (n == null) return
        if (depth > maxDepth) {
            maxDepth = depth
            sum = 0
            sum += n.`val`
        } else if (depth == maxDepth) {
            sum += n.`val`
        }

        dfs(n.left, depth + 1)
        dfs(n.right, depth + 1)
    }
    dfs(root, 0)
    return sum
}

fun main(args: Array<String>) {
    println(
        deepestLeavesSum(
            TreeNode(1).also { it.left = TreeNode(2); it.right = TreeNode(3) })
    )
}
