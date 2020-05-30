package leet_code.phone_interview.random.two

import leet_code.TreeNode

/**
 * In a binary tree, the root node is at depth 0, and children of each depth k node are at depth k+1.
 * Two nodes of a binary tree are cousins if they have the same depth, but have different parents.
 * We are given the root of a binary tree with unique values, and the values x and y of two different nodes in the tree.
 * Return true if and only if the nodes corresponding to the values x and y are cousins.
 *
 *
 * Example 1:
 * Input: root = [1,2,3,4], x = 4, y = 3
 * Output: false
 *
 *
 * Example 2:
 * Input: root = [1,2,3,null,4,null,5], x = 5, y = 4
 * Output: true
 *
 *
 * Example 3:
 * Input: root = [1,2,3,null,4], x = 2, y = 3
 * Output: false
 *
 *
 * Note:
 *
 * The number of nodes in the tree will be between 2 and 100.
 * Each node has a unique integer value from 1 to 100.
 */
fun isCousins(root: TreeNode?, x: Int, y: Int): Boolean {
    var parent1: Pair<Int?, Int>? = null
    var parent2: Pair<Int?, Int>? = null
    fun doIsCousins(node: TreeNode?, parent: TreeNode?, depth: Int, x: Int, y: Int) {
        if (node == null) {
            return
        }

        if (node.`val` == x) {
            parent1 = Pair(parent?.`val`, depth)
        }
        if (node.`val` == y) {
            parent2 = Pair(parent?.`val`, depth)
        }
        if (parent1 != null && parent2 != null) {
            return
        }

        doIsCousins(node.left, node, depth + 1, x, y)
        doIsCousins(node.right, node, depth + 1, x, y)
    }
    doIsCousins(root, null, 0, x, y)
    return parent1!!.first != parent2!!.first && parent1!!.second == parent2!!.second
}
