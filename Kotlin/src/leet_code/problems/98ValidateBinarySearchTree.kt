package leet_code.problems

import leet_code.TreeNode

/**
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 *
 * Assume a BST is defined as follows:
 *
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 *
 *
 * Example 1:
 *
 *   2
 *  / \
 * 1   3
 *
 * Input: [2,1,3]
 * Output: true
 * Example 2:
 *
 *      5
 *     / \
 *    1  4
 *      / \
 *     3   6
 *
 * Input: [5,1,4,null,null,3,6]
 * Output: false
 * Explanation: The root node's value is 5 but its right child's value is 4.
 *
 *      5
 *     / \
 *    1  8
 *      / \
 *     7   6
 *    /
 *    6
 */
fun isValidBST(root: TreeNode?): Boolean {
    fun _isValidBST(node: TreeNode?, min: Long, max: Long): Boolean {
        if (node == null) return true
        if (node.`val` <= min || node.`val` >= max) return false

        val validLeft = _isValidBST(node.left, min, node.`val`.toLong())
        if (!validLeft) return false

        val validRight = _isValidBST(node.right, node.`val`.toLong(), max)
        if (!validRight) return false

        return true
    }
    return _isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE)
}

fun main() {
    println(isValidBST(TreeNode(123)))
}