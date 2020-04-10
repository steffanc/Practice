/**
 * Given an integer n, generate all structurally unique BST's (binary search trees) that store values 1 ... n.
 */
object UniqueBinarySearchTreesII {
    fun generateTrees(n: Int): List<TreeNode?> {
        return doGenerateTrees(1, n)
    }

    private fun doGenerateTrees(i: Int, j: Int): List<TreeNode?> {
        if (i > j) return emptyList()
        val trees = mutableListOf<TreeNode?>()
        (i..j).toList().forEach { num ->
            var leftTrees = doGenerateTrees(i, num - 1)
            var rightTrees = doGenerateTrees(num + 1, j)

            leftTrees = if (leftTrees.isEmpty()) listOf(null) else leftTrees
            rightTrees = if (rightTrees.isEmpty()) listOf(null) else rightTrees

            leftTrees.forEach { leftNode ->
                rightTrees.forEach { rightNode ->
                    trees.add(TreeNode(num).also { it.left = leftNode; it.right = rightNode })
                }
            }
        }
        return trees
    }
}

fun main(args: Array<String>) {
    val answer = UniqueBinarySearchTreesII.generateTrees(3)
    answer.forEach { println(it) }
}
