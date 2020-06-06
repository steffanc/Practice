package leet_code.problems

import leet_code.TreeNode

/**
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
 *
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and
 * q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
 *
 * Given the following binary tree:  root = [3,5,1,6,2,0,8,null,null,7,4]
 *
 * Example 1:
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * Output: 3
 * Explanation: The LCA of nodes 5 and 1 is 3.
 *
 * Example 2:
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * Output: 5
 * Explanation: The LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.
 *
 * Note:
 * All of the nodes' values will be unique.
 * p and q are different and both values will exist in the binary tree.
 *
 * O(n), O(1)
 */
fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
    var lca: TreeNode? = null
    fun _lowestCommonAncestor(node: TreeNode?, p: TreeNode?, q: TreeNode?): Boolean {
        if (node == null) return false
        val current = node.`val` == p?.`val` || node.`val` == q?.`val`

        val left = _lowestCommonAncestor(node.left, p, q)
        if (lca != null) return true

        val right = _lowestCommonAncestor(node.right, p, q)
        if (lca != null) return true

        if ((current && left) || (current && right) || (left && right)) lca = node
        return current || left || right
    }
    _lowestCommonAncestor(root, p, q)
    return lca
}