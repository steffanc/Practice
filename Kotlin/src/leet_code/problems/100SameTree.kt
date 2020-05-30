package leet_code.problems

import leet_code.TreeNode

/**
 *
 * Given two binary trees, write a function to check if they are the same or not.
 *
 * Two binary trees are considered the same if they are structurally identical and the nodes have the same value.
 *
 * Example 1:
 *
 * Input:     1         1
 *           / \       / \
 *          2   3     2   3
 *
 * [1,2,3],   [1,2,3]
 *
 * Output: true
 * Example 2:
 *
 * Input:     1         1
 *           /           \
 *          2             2
 *
 * [1,2],     [1,null,2]
 *
 * Output: false
 * Example 3:
 *
 * Input:     1         1
 *           / \       / \
 *          2   1     1   2
 *
 * [1,2,1],   [1,1,2]
 *
 * Output: false
 */
fun isSameTree(p: TreeNode?, q: TreeNode?): Boolean {
    if (p === q) {
        return true
    }
    if (p?.`val` != q?.`val`) {
        return false
    }

    return isSameTree(p?.left, q?.left) && isSameTree(p?.right, q?.right)
}

fun main() {
    println(
        isSameTree(
            null,
            null
        )
    )
}
