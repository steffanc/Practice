object BinaryTreeInOrderTraversal {
    fun inorderTraversal(root: TreeNode?): List<Int> {
        val list = mutableListOf<Int>()
        if (root?.left != null) {
            list.addAll(inorderTraversal(root.left))
        }

        root?.`val`?.let { list.add(it) }

        if (root?.right != null) {
            list.addAll(inorderTraversal(root.right))
        }

        return list
    }
}

fun main(args: Array<String>) {
    val tree1 = TreeNode(1).also { it.right = TreeNode(2).also { it.left = TreeNode(3) } }
    println(BinaryTreeInOrderTraversal.inorderTraversal(tree1))
}
