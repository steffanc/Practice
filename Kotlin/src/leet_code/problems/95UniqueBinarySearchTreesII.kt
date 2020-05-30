package leet_code.problems

import leet_code.TreeNode

/**
 * Given an integer n, generate all structurally unique BST's (binary search trees) that store values 1 ... n.
 */
fun generateTrees(n: Int): List<TreeNode?> {
    return doGenerateTrees(1, n)
}

private fun doGenerateTrees(i: Int, j: Int): List<TreeNode?> {
    if (i > j) return listOf(null)
    val trees = mutableListOf<TreeNode?>()
    (i..j).toList().forEach { num ->
        val leftTrees = doGenerateTrees(i, num - 1)
        val rightTrees = doGenerateTrees(num + 1, j)

        leftTrees.forEach { leftNode ->
            rightTrees.forEach { rightNode ->
                trees.add(TreeNode(num).also { it.left = leftNode; it.right = rightNode })
            }
        }
    }
    return trees
}

fun main(args: Array<String>) {
    val answer = generateTrees(3)
    answer.forEach { println(it) }
}
